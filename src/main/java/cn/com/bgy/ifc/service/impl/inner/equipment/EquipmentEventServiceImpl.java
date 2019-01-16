package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.*;
import cn.com.bgy.ifc.dao.equipment.EquipmentEventDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentEventVo;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentEventService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public ResponseVO<Object> createEquipmentEvent(EquipmentEvent equipmentEvent) {
        return null;
    }

    @Override
    public ResponseVO<Object> editEquipmentEvent(EquipmentEvent equipmentEvent) {
        return null;
    }

    @SystemLogAfterSave(type = SystemLogType.INTERFACE_LOG, description = "同步物联设备事件信息", login = LoginState.NOT_LOGIN)
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
                            return ResponseVO.success().setMsg("设备事件信息同步成功！");
                        } else {
                            return ResponseVO.error().setMsg("设备事件信息同步失败！");
                        }
                    } else {
                        return ResponseVO.success().setMsg("暂无中联永安设备事件信息同步！");
                    }
                } else {
                    return ResponseVO.error().setMsg("获取中联永安设备事件信息失败!");
                }
            } else {
                return ResponseVO.error().setMsg("获取中联永安接口配置信息失败！");
            }
        } catch (Exception e) {
            logger.error("获取中联永安设备事件信息接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取中联永安设备事件信息接口请求异常！", e));
        }
    }

    @Override
    public ResponseVO<Object> deleteEquipmentEvent(String ids) {
        return null;
    }
}
