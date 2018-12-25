package cn.com.bgy.ifc.dao.repair;

import java.util.List;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.repair.MaintenancePlan;
import cn.com.bgy.ifc.entity.vo.repair.MaintenancePlanVo;

public interface MaintenancePlanDao extends BaseDao<MaintenancePlanVo>{
	  /**批量删除*/
    int delete(List<Long> list);
}