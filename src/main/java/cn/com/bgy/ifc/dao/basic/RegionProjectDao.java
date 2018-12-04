package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.RegionProject;

public interface RegionProjectDao {
    int insert(RegionProject record);

    int insertSelective(RegionProject record);
}