package cn.com.bgy.ifc.dao.basic.region;

import cn.com.bgy.ifc.entity.po.basic.region.RegionCourt;

public interface RegionCourtDao {
    int insert(RegionCourt record);

    int insertSelective(RegionCourt record);
}