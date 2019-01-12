package cn.com.bgy.ifc.domain.interfaces.maintenance;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePeriodic;
/**
 * 维保周期性任务
 * @author lvbingjian
 * 2018年12月27日16:24:28
 *
 */
public interface MaintenancePeriodicDomain extends BaseDomain<MaintenancePeriodic> {
	/**
	 * 分页查询
	 * @param page
	 * @param
	 * @return
	 */
	 PageInfo<MaintenancePeriodic> queryListByPage(Page<MaintenancePeriodic> page, MaintenancePeriodic maintenancePeriodic);
	 int saveOrders(MaintenancePeriodic m);
}
