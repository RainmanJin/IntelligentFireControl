package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.alarm.AlarmCount;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentEventVo;

import java.util.List;

public interface EquipmentEventDao extends BaseDao<EquipmentEvent> {

    /**
     * 查询事件管理列表
     * @param equipmentEventVo
     * @return
     */
    List<EquipmentEvent> queryListByParam(EquipmentEventVo equipmentEventVo);

}