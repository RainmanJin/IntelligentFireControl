package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.*;
import cn.com.bgy.ifc.dao.equipment.AnalogDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.AnalogDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.equipment.Analog;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.AnalogService;
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
 * @description:模拟量管理
 * @date: 2019-01-15 16:29
 **/
@Service
public class AnalogServiceImpl implements AnalogService {

    private static Logger logger = LoggerFactory.getLogger(AnalogServiceImpl.class);

    @Resource
    private AnalogDao analogDao;

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private AnalogDomain analogDomain;


    @Override
    public PageInfo<Analog> queryListByPage(Page page, Analog analog) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<Analog> list = analogDao.queryListByParam(analog);
        PageInfo<Analog> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Analog findById(Long id) {
        return analogDao.findById(id);
    }

    @Override
    public int insertAnalog(JSONObject jsonObject) {
        Analog analog = jsonObject.toJavaObject(Analog.class);
        if (analog != null) {
            //添加设备模拟量值和模拟量管理
            return analogDomain.insertAnalogAndState(analog);
        }
        return 0;
    }

    @Override
    public ResponseVO<Object> createAnalog(Analog analog) {
        return null;
    }

    @Override
    public ResponseVO<Object> editAnalog(Analog analog) {
        return null;
    }

    @SystemLogAfterSave(type = SystemLogType.INTERFACE_LOG, description = "同步物联设备模拟量", login = LoginState.NOT_LOGIN)
    @Override
    public ResponseVO<Object> synchroAnalog(int pageNum, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String baseUrl = config.getUrl() + "/device/values";
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
                                //采集时间转换
                                if ("caputureTime".equals(key)) {
                                    if (value != null) {
                                        value = TimeUtil.formatDateOfTimestamp(Long.valueOf(value.toString()));
                                    }
                                }
                                newValueMap.put(EntityUtil.humpToLine(key), value);
                            });
                            datas.add(newValueMap);
                        }
                        int result = DbUtil.insertAll("analog", executeName, datas);
                        if (result == totalCount) {
                            return ResponseVO.success().setMsg("设备模拟量同步成功！");
                        } else {
                            return ResponseVO.error().setMsg("设备模拟量同步失败！");
                        }
                    } else {
                        return ResponseVO.success().setMsg("暂无中联永安设备模拟量同步！");
                    }
                } else {
                    return ResponseVO.error().setMsg("获取中联永安设备模拟量失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安设备模拟量接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安设备模拟量接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> deleteAnalog(String ids) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                List<Long> idList = ListUtil.getListId(ids);
                String url = "";
                if(idList.size()>1){
                    String newIds = ListUtil.getIdStr(idList);
                    url = config.getUrl() + "/device/values?ids=" + newIds;
                }else{
                    url = config.getUrl() + "/device/values/" + idList.get(0);
                }
                JSONObject response = HttpHelper.httpDelete(url, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = analogDao.deleteBatch(idList);
                        if (result == idList.size()) {
                            return ResponseVO.deleteSuccess();
                        } else {
                            return ResponseVO.deleteError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("刪除失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安刪除模拟量数据失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("删除中联永安刪除模拟量数据接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("删除中联永安刪除模拟量数据接口请求异常！", e));
        }
    }
}
