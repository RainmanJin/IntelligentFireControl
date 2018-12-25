package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.entity.po.repair.MaintenancePlan;

public interface MaintenancePlanDao {
    int insert(MaintenancePlan record);

    int insertSelective(MaintenancePlan record);
}