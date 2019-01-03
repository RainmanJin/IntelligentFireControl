package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.FirePlanTest;

public interface FirePlanTestDao {
    int insert(FirePlanTest record);

    int insertSelective(FirePlanTest record);
}