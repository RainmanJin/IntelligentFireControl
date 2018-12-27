package cn.com.bgy.ifc.domain.interfaces.maintenance;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenancePlanDetail;
/**
 * 维保计划明细
 * @author lvbingjian
 *2018年12月27日13:54:42
 */
public interface MaintenancePlanDetailDomain extends BaseDomain<MaintenancePlanDetail> {
	 PageInfo<MaintenancePlanDetail> queryListByPage(Page<MaintenancePlanDetail> page, MaintenancePlanDetail aintenancePlanDetail);

}
