package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.entity.po.repair.MaintenancePlanDetail;

public interface MaintenancePlanDetailDao {
    int insert(MaintenancePlanDetail record);

    int insertSelective(MaintenancePlanDetail record);
}