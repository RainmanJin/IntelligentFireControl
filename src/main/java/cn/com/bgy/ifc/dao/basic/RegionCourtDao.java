package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.RegionCourt;

public interface RegionCourtDao {
    int insert(RegionCourt record);

    int insertSelective(RegionCourt record);
}