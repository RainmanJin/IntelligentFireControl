package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;

import java.util.List;
import java.util.Map;

public interface EquipmentTypeDao extends BaseDao<EquipmentType> {

    List<Map<String,Object>> queryListEquipmentType();

    int addEquipmentType( EquipmentType equipmentType );

    int updateEquipmentType( EquipmentType equipmentType );

    int deleteEquipmentType( List<Long> list );
}