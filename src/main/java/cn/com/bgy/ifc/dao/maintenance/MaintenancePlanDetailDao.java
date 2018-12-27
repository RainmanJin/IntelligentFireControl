package cn.com.bgy.ifc.dao.maintenance;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlanDetail;

public interface MaintenancePlanDetailDao extends BaseDao<MaintenancePlanDetail>{
    int insert(MaintenancePlanDetail record);

    int insertSelective(MaintenancePlanDetail record);
}