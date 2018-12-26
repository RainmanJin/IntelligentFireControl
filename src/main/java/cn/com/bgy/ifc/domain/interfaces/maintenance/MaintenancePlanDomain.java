package cn.com.bgy.ifc.domain.interfaces.maintenance;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlan;

public interface MaintenancePlanDomain extends BaseDomain<MaintenancePlan> {
	PageInfo<MaintenancePlan> queryListByPage(Page<MaintenancePlan> page,MaintenancePlan vo);
	

}
