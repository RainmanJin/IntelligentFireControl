package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.entity.po.equipment.quipment.EquipmentInfo;

public interface EquipmentInfoDao {
    int insert(EquipmentInfo record);

    int insertSelective(EquipmentInfo record);
}