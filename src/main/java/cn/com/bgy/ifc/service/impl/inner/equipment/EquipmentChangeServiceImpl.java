package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.*;
import cn.com.bgy.ifc.dao.equipment.EquipmentChangeDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentChange;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentChangeService;
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
 * @description:设备状态变化管理
 * @date: 2019-01-17 11:33
 **/
@Service
public class EquipmentChangeServiceImpl implements EquipmentChangeService {

    private static Logger logger = LoggerFactory.getLogger(EquipmentChangeServiceImpl.class);

    @Resource
    private EquipmentChangeDao equipmentChangeDao;

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Override
    public PageInfo<EquipmentChange> queryListByPage(Page page, EquipmentChange equipmentChange) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentChange> list = equipmentChangeDao.queryListByParam(equipmentChange);
        PageInfo<EquipmentChange> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public EquipmentChange findById(Long id) {
        return equipmentChangeDao.findById(id);
    }

    @Override
    public ResponseVO<Object> createEquipmentChange(EquipmentChange equipmentChange) {
        return null;
    }

    @Override
    public ResponseVO<Object> editEquipmentChange(EquipmentChange equipmentChange) {
        return null;
    }

    @SystemLogAfterSave(type = SystemLogType.INTERFACE_LOG, description = "同步设备状态变化", login = LoginState.NOT_LOGIN)
    @Override
    public ResponseVO<Object> synchroEquipmentChange(int pageNum, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String baseUrl = config.getUrl() + "/device/statuses";
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
                        String executeName = "REPLACE INTO ";
                        int size = configList.size();
                        List<Map<String, Object>> datas = new ArrayList<>();
                        for (int i = 0; i < size; i++) {
                            Map<String, Object> newValueMap = new HashMap<>();
                            Map<String, Object> valueMap = configList.get(i);
                            valueMap.forEach((key, value) -> {
                                //发生时间转换
                                if ("occuredTime".equals(key)) {
                                    if (value != null) {
                                        value = TimeUtil.formatDateOfTimestamp(Long.valueOf(value.toString()));
                                    }
                                }
                                newValueMap.put(EntityUtil.humpToLine(key), value);
                            });
                            datas.add(newValueMap);
                        }
                        int result = DbUtil.insertAll("equipment_change", executeName, datas);
                        if (result == totalCount) {
                            return ResponseVO.success().setMsg("设备状态变化同步成功！");
                        } else {
                            return ResponseVO.error().setMsg("设备状态变化同步失败！");
                        }
                    } else {
                        return ResponseVO.success().setMsg("暂无中联永安设备状态变化数据！");
                    }
                } else {
                    return ResponseVO.error().setMsg("获取中联永安设备状态变化失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安设备状态变化接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安设备状态变化接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> deleteEquipmentChange(String ids) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                List<Long> idList = ListUtil.getListId(ids);
                String url = "";
                if(idList.size()>1){
                    String newIds = ListUtil.getIdStr(idList);
                    url = config.getUrl() + "/device/statuses?ids=" + newIds;
                }else{
                    url = config.getUrl() + "/device/statuses/" + idList.get(0);
                }
                JSONObject response = HttpHelper.httpDelete(url, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = equipmentChangeDao.deleteBatch(idList);
                        if (result == idList.size()) {
                            return ResponseVO.deleteSuccess();
                        } else {
                            return ResponseVO.deleteError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("刪除失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安刪除设备状态变化失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("删除中联永安设备状态变化接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("删除中联永安设备状态变化接口请求异常！", e));
        }
    }
}
