package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.equipment.EquipmentStateVo;

import java.util.List;

public interface EquipmentStateDao extends BaseDao<EquipmentState> {

    List<EquipmentState> queryListByParam(EquipmentStateVo equipmentStateVo);

}