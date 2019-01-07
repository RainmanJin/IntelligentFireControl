package cn.com.bgy.ifc.domain.interfaces.maintenance;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlan;

public interface MaintenancePlanDomain extends BaseDomain<MaintenancePlan> {
	PageInfo<MaintenancePlan> queryListByPage(Page<MaintenancePlan> page,MaintenancePlan vo);
	/**
	 * 通过设备类型ID新增维保工单
	 * @param id
	 * @return
	 */
	int saveOrders(MaintenancePlan t);
	/**
	 * 通过 设备类型ID找到设备ID数组
	 * @param id
	 * @return
	 */
	List<Map<String,Object>>  ordIds(MaintenancePlan t);
}
