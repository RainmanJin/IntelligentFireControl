package cn.com.bgy.ifc.controller.inner.alarm;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.entity.po.alarm.AlarmCount;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:公用实时告警
 * @date: 2019-02-12 17:04
 **/
@RestController
@RequestMapping("/alarm/communal")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    /**
     * @author: ZhangCheng
     * @description:告警数据统计
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("queryAlarmCount")
    public ResponseVO<Object> queryAlarmCount(){
        AlarmCount alarmCount=alarmService.queryAlarmCount();
        return ResponseVO.<Object>success().setData(alarmCount);
    }
    /**
     * @author: ZhangCheng
     * @description:处理设备告警
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("handleData")
    @SystemLogAfterSave(description = "处理设备告警")
    public ResponseVO<Object> handleData(Long id) {
        return alarmService.editAlarm(id);
    }

    /**
     * @author: ZhangCheng
     * @description:批量处理设备告警
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("handleDataList")
    @SystemLogAfterSave(description = "批量处理设备告警")
    public ResponseVO<Object> handleDataList(String ids) {
        return alarmService.handleDataList(ids);
    }
}
