package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.EquipmentInfo;

public interface EquipmentInfoDao {
    int insert(EquipmentInfo record);

    int insertSelective(EquipmentInfo record);
}