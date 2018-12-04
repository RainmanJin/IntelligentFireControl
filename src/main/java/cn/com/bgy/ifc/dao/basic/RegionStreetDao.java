package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.RegionStreet;

public interface RegionStreetDao {
    int insert(RegionStreet record);

    int insertSelective(RegionStreet record);
}