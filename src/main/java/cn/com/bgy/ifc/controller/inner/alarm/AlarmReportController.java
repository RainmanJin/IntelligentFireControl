package cn.com.bgy.ifc.controller.inner.alarm;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.entity.po.alarm.AlarmCount;
import cn.com.bgy.ifc.entity.po.equipment.Analog;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentEventVo;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentEventService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:实时告警告警列表
 * @date: 2019-01-18 09:55
 **/
@RestController
@RequestMapping("/alarm/report")
public class AlarmReportController {

    @Autowired
    private AlarmService alarmService;

    @Autowired
    private EquipmentEventService equipmentEventService;

    /**
     * @author: ZhangCheng
     * @description:告警列表
     * @param: [page]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent>>
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<EquipmentEvent>> queryPage(Page<EquipmentEvent> page) {
        Integer type= EquipmentConstant.StateEnum.CALL_POLICE.getValue();
        PageInfo<EquipmentEvent> pageInfo = alarmService.queryListByPage(page,type);
        return ResponseVO.<PageInfo<EquipmentEvent>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:告警数据统计
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("queryAlarmCount")
    public ResponseVO<Object>  queryAlarmCount(){
        AlarmCount alarmCount=alarmService.queryAlarmCount();
        return ResponseVO.<Object>success().setData(alarmCount);
    }

    /**
     * @author: ZhangCheng
     * @description:处理设备告警
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("editData")
    @SystemLogAfterSave(description = "处理设备告警")
    public ResponseVO<Object> edit(Long id) {
        EquipmentEvent equipmentEvent = equipmentEventService.findById(id);
        return equipmentEventService.editEquipmentEvent(equipmentEvent);
    }
}
