package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionBuilding;

public interface RegionBuildingDao {
    int insert(RegionBuilding record);

    int insertSelective(RegionBuilding record);
}