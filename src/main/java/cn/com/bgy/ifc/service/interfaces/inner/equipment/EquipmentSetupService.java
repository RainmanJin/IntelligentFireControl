package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentSetup;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:物联设备设置
 * @date: 2019-01-26 11:36
 **/
public interface EquipmentSetupService extends BaseService<EquipmentSetup> {

    /**
     * 更改设备告警等级
     * @param equipmentSetup
     * @return
     */
    int updateAlarmGrade(EquipmentSetup equipmentSetup);

    /**
     * 更改设备告警阀值
     * @param equipmentSetup
     * @return
     */
    int updateAlarmThreshold(EquipmentSetup equipmentSetup);

    /**
     * 批量更改设备告警等级
     * @param list
     * @return
     */
    int updateAlarmGradeList(List<EquipmentSetup> list);

    /**
     * 批量更改设备告警阀值
     * @param list
     * @return
     */
    int updateAlarmThresholdList(List<EquipmentSetup> list);
}
