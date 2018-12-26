package cn.com.bgy.ifc.dao.maintenance;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlan;

import java.util.List;

public interface MaintenancePlanDao extends BaseDao<MaintenancePlan>{
	  /**批量删除*/
    int delete(List<Long> list);
}