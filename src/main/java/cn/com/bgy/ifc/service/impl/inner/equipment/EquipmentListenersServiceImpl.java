package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.DbUtil;
import cn.com.bgy.ifc.bgy.utils.ExceptionUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentListenersDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentListeners;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentListenersService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-16 15:30
 **/
@Service
public class EquipmentListenersServiceImpl implements EquipmentListenersService {

    private static Logger logger = LoggerFactory.getLogger(EquipmentListenersServiceImpl.class);

    @Resource
    private EquipmentListenersDao equipmentListenersDao;

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Override
    public PageInfo<EquipmentListeners> queryListByPage(Page page, String keyword) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentListeners> list = equipmentListenersDao.queryListByPage(keyword);
        PageInfo<EquipmentListeners> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public EquipmentListeners findById(Long id) {
        return equipmentListenersDao.findById(id);
    }

    @Override
    public ResponseVO<Object> createEquipmentListeners(EquipmentListeners equipmentListeners) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/event/listeners";
                Map<String, Object> data = new HashMap<>();
                data.put("url", equipmentListeners.getUrl());
                JSONObject response = HttpHelper.httpPost(url, data, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        JSONObject jsonObject = response.getJSONObject("data");
                        Long id = jsonObject.getLong("id");
                        equipmentListeners.setId(id);
                        int result = equipmentListenersDao.insertSelective(equipmentListeners);
                        if (result == 1) {
                            return ResponseVO.addSuccess();
                        } else {
                            return ResponseVO.addError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("添加失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安创建事件监听信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安设备接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安事件监听接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安事件监听接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> editEquipmentListeners(EquipmentListeners equipmentListeners) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long id = equipmentListeners.getId();
                String url = config.getUrl() + "/event/listeners/" + id;
                Map<String, Object> data = new HashMap<>();
                data.put("url", equipmentListeners.getUrl());
                JSONObject response = HttpHelper.httpPut(url, data, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = equipmentListenersDao.updateSelective(equipmentListeners);
                        if (result == 1) {
                            return ResponseVO.addSuccess();
                        } else {
                            return ResponseVO.addError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("修改失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安修改事件监听信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安设备接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安事件监听接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安事件监听接口请求异常！", e));
        }
    }

    @SystemLogAfterSave(type = SystemLogType.INTERFACE_LOG, description = "同步物联设备事件监听配置",login= LoginState.NOT_LOGIN)
    @Override
    public ResponseVO<Object> synchroEquipmentListeners(int pageNum, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String baseUrl = config.getUrl() + "/event/listeners";
                String url = baseUrl + "?page=" + pageNum + "&size" + pageSize;
                JSONObject response = HttpHelper.httpGet(url, null);
                if (response != null) {
                    List<Map<String, Object>> configList = new ArrayList();
                    ResponseUtil.getResultListMap(configList, response, "data", "list");
                    // 总页数
                    int pageCount = ResponseUtil.getPages(response, "pages");
                    if (pageCount > 1) {
                        ResponseUtil.getListMapByPage(pageNum, pageSize, pageCount, baseUrl, configList, "data", "list");
                    }
                    int totalCount = configList.size();
                    if (totalCount > 0) {
                        int result = DbUtil.replaceAll("equipment_listeners", configList);
                        if (result == totalCount) {
                            return ResponseVO.success().setMsg("设备事件监听数据同步成功！");
                        } else {
                            return ResponseVO.error().setMsg("设备事件监听数据同步失败！");
                        }
                    } else {
                        return ResponseVO.success().setMsg("暂无中联永安事件监听数据同步！");
                    }
                } else {
                    return ResponseVO.error().setMsg("获取中联永安事件监听信息列表失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安事件监听接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安事件监听接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> deleteEquipmentListeners(String ids) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                List<Long> idList = ListUtil.getListId(ids);
                String url = "";
                if(idList.size()>1){
                    String newIds = ListUtil.getIdStr(idList);
                    url = config.getUrl() + "/event/listeners?ids=" + newIds;
                }else{
                    url = config.getUrl() + "/event/listeners/" + idList.get(0);
                }
                JSONObject response = HttpHelper.httpDelete(url, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = equipmentListenersDao.deleteBatch(idList);
                        if (result == idList.size()) {
                            return ResponseVO.deleteSuccess();
                        } else {
                            return ResponseVO.deleteError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("刪除失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安刪除事件监听信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("删除中联永安事件监听信息接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("删除中联永安事件监听信息接口请求异常！", e));
        }
    }
}
