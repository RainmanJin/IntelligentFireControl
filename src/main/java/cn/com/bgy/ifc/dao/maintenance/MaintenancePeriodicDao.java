package cn.com.bgy.ifc.dao.maintenance;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePeriodic;

public interface MaintenancePeriodicDao {
    int insert(MaintenancePeriodic record);

    int insertSelective(MaintenancePeriodic record);
}