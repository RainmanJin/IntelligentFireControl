package cn.com.bgy.ifc.domain.interfaces.maintenance;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrderItem;
/**
 * 维保工单项目结果表   接口
 * @author lvbingjian
 * 2018年12月27日16:24:28
 *
 */
public interface MaintenanceOrderItemDomain extends BaseDomain<MaintenanceOrderItem> {
	/**
	 * 分页查询
	 * @param page
	 * @param 查询条件
	 * @return
	 */
	 PageInfo<MaintenanceOrderItem> queryListByPage(Page<MaintenanceOrderItem> page, MaintenanceOrderItem aintenanceOrderItem);
}
