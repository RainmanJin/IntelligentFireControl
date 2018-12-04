package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.RegionInfo;

public interface RegionInfoDao {
    int insert(RegionInfo record);

    int insertSelective(RegionInfo record);
}