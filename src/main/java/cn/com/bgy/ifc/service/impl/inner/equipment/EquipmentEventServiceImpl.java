package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.*;
import cn.com.bgy.ifc.dao.alarm.RealTimeAlarmDao;
import cn.com.bgy.ifc.dao.equipment.EquipmentEventDao;
import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.alarm.RealTimeAlarm;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentEventVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentEventService;
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
 * @description:物联设备事件管理
 * @date: 2019-01-15 17:12
 **/
@Service
public class EquipmentEventServiceImpl implements EquipmentEventService {

    private static Logger logger = LoggerFactory.getLogger(EquipmentEventServiceImpl.class);

    @Resource
    private EquipmentEventDao equipmentEventDao;

    @Resource
    private EquipmentInfoDao equipmentInfoDao;

    @Resource
    private RealTimeAlarmDao realTimeAlarmDao;

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Override
    public PageInfo<EquipmentEvent> queryListByPage(Page page, EquipmentEventVo equipmentEventVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentEvent> list = equipmentEventDao.queryListByParam(equipmentEventVo);
        PageInfo<EquipmentEvent> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public EquipmentEvent findById(Long id) {
        return equipmentEventDao.findById(id);
    }

    @Override
    public int insertEquipmentEvent(JSONObject jsonObject) {
        EquipmentEvent equipmentEvent = jsonObject.toJavaObject(EquipmentEvent.class);
        if (equipmentEvent != null) {
            Long id = equipmentEvent.getId();
            if (id != null) {
                EquipmentEvent event = equipmentEventDao.findById(id);
                if (event != null) {
                    RealTimeAlarm realTimeAlarm = realTimeAlarmDao.findByEventId(id);
                    if (realTimeAlarm != null) {
                        realTimeAlarmDao.updateSelective(objectSlicing(realTimeAlarm, equipmentEvent));
                    }
                    return equipmentEventDao.updateSelective(equipmentEvent);
                } else {
                    EquipmentInfo equipmentInfo = equipmentInfoDao.findByStateId(equipmentEvent.getDeviceId());
                    if (equipmentInfo != null) {
                        RealTimeAlarm realTimeAlarm = new RealTimeAlarm();
                        realTimeAlarm.setDeviceId(equipmentInfo.getId());
                        realTimeAlarmDao.insertSelective(objectSlicing(realTimeAlarm, equipmentEvent));
                    }
                    return equipmentEventDao.insertSelective(equipmentEvent);
                }
            }
        }
        return 0;
    }

    @Override
    public ResponseVO<Object> createEquipmentEvent(EquipmentEvent equipmentEvent) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/event/events";
                Map<String, Object> data = new HashMap<>();
                data.put("deviceId", equipmentEvent.getDeviceId());
                data.put("type", equipmentEvent.getType());
                data.put("description", equipmentEvent.getDescription());
                data.put("firstTime", equipmentEvent.getFirstTime().getTime());
                data.put("lastTime", equipmentEvent.getLastTime().getTime());
                data.put("reportCount", equipmentEvent.getReportCount());
                data.put("status", equipmentEvent.getStatus());
                JSONObject response = HttpHelper.httpPost(url, data, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        JSONObject jsonObject = response.getJSONObject("data");
                        Long id = jsonObject.getLong("id");
                        equipmentEvent.setId(id);
                        int result = equipmentEventDao.insertSelective(equipmentEvent);
                        if (result == 1) {
                            return ResponseVO.addSuccess();
                        } else {
                            return ResponseVO.addError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("添加失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安创建事件信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安设备接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安事件接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安事件接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> editEquipmentEvent(EquipmentEvent equipmentEvent) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long id = equipmentEvent.getId();
                String url = config.getUrl() + "/event/events/" + id;
                Map<String, Object> data = new HashMap<>();
                data.put("deviceId", equipmentEvent.getDeviceId());
                data.put("type", equipmentEvent.getType());
                data.put("description", equipmentEvent.getDescription());
                data.put("firstTime", equipmentEvent.getFirstTime().getTime());
                data.put("lastTime", equipmentEvent.getLastTime().getTime());
                data.put("reportCount", equipmentEvent.getReportCount());
                data.put("status", equipmentEvent.getStatus());
                JSONObject response = HttpHelper.httpPut(url, data, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = equipmentEventDao.updateSelective(equipmentEvent);
                        if (result == 1) {
                            return ResponseVO.editSuccess();
                        } else {
                            return ResponseVO.editError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("修改失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安修改事件信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安设备接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安事件信息接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安事件信息接口请求异常！", e));
        }
    }

    @SystemLogAfterSave(type = SystemLogType.INTERFACE_LOG, description = "同步物联事件信息", login = LoginState.NOT_LOGIN)
    @Override
    public ResponseVO<Object> synchroEquipmentEvent(int pageNum, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String baseUrl = config.getUrl() + "/event/events";
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
                                //第一次产生时间转换
                                if ("firstTime".equals(key)) {
                                    if (value != null) {
                                        value = TimeUtil.formatDateOfTimestamp(Long.valueOf(value.toString()));
                                    }
                                }
                                //最近一次产生时间转换
                                if ("lastTime".equals(key)) {
                                    if (value != null) {
                                        value = TimeUtil.formatDateOfTimestamp(Long.valueOf(value.toString()));
                                    }
                                }
                                newValueMap.put(EntityUtil.humpToLine(key), value);
                            });
                            datas.add(newValueMap);
                        }
                        int result = DbUtil.insertAll("equipment_event", executeName, datas);
                        if (result == totalCount) {
                            return ResponseVO.success().setMsg("事件信息同步成功！");
                        } else {
                            return ResponseVO.error().setMsg("事件信息同步失败！");
                        }
                    } else {
                        return ResponseVO.success().setMsg("暂无中联永安事件信息同步！");
                    }
                } else {
                    return ResponseVO.error().setMsg("获取中联永安事件信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安事件信息接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安事件信息接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> deleteEquipmentEvent(String ids) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryInternetThingConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                List<Long> idList = ListUtil.getListId(ids);
                String url = "";
                if (idList.size() > 1) {
                    String newIds = ListUtil.getIdStr(idList);
                    url = config.getUrl() + "/event/events?ids=" + newIds;
                } else {
                    url = config.getUrl() + "/event/events/" + idList.get(0);
                }
                JSONObject response = HttpHelper.httpDelete(url, null);
                if (response != null) {
                    //data作为key获取JSONObject
                    Integer statusCode = response.getInteger("code");
                    String message = response.getString("message");
                    if (HttpStatus.SC_OK == statusCode) {
                        int result = equipmentEventDao.deleteBatch(idList);
                        if (result == idList.size()) {
                            return ResponseVO.deleteSuccess();
                        } else {
                            return ResponseVO.deleteError();
                        }
                    } else {
                        return ResponseVO.error().setMsg("刪除失败!错误信息：" + message);
                    }
                } else {
                    return ResponseVO.error().setMsg("中联永安刪除事件信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("删除中联永安事件信息接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("删除中联永安事件信息接口请求异常！", e));
        }
    }

    private RealTimeAlarm objectSlicing(RealTimeAlarm realTimeAlarm, EquipmentEvent equipmentEvent) {
        realTimeAlarm.setStatus(equipmentEvent.getStatus());
        realTimeAlarm.setType(equipmentEvent.getType());
        realTimeAlarm.setDescription(equipmentEvent.getDescription());
        realTimeAlarm.setEventId(equipmentEvent.getId());
        realTimeAlarm.setReportCount(equipmentEvent.getReportCount());
        realTimeAlarm.setFirstTime(equipmentEvent.getFirstTime());
        realTimeAlarm.setLastTime(equipmentEvent.getLastTime());
        return realTimeAlarm;
    }
}
