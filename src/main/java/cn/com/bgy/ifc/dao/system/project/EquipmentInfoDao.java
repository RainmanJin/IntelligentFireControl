package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.entity.po.equipment.quipment.EquipmentInfo;

public interface EquipmentInfoDao {
    int insert(EquipmentInfo record);

    int insertSelective(EquipmentInfo record);
}