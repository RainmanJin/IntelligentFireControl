package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.RegionBuilding;

public interface RegionBuildingDao {
    int insert(RegionBuilding record);

    int insertSelective(RegionBuilding record);
}