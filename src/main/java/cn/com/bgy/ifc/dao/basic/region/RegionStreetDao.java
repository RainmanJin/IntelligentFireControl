package cn.com.bgy.ifc.dao.basic.region;

import cn.com.bgy.ifc.entity.po.basic.region.RegionStreet;

public interface RegionStreetDao {
    int insert(RegionStreet record);

    int insertSelective(RegionStreet record);
}