package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.FireFacilities;

public interface FireFacilitiesDao {
    int insert(FireFacilities record);

    int insertSelective(FireFacilities record);
}