package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;

public interface EquipmentVersionDao {
    int insert(EquipmentVersion record);

    int insertSelective(EquipmentVersion record);
}