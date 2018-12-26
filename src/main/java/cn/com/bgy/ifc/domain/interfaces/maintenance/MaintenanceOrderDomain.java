package cn.com.bgy.ifc.domain.interfaces.maintenance;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContract;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrder;
/**
 * 维保工单业务
 * @author lvbingjian
 * date 2018年12月26日15:23:39
 *
 */
public interface MaintenanceOrderDomain extends BaseDomain<MaintenanceOrder> {
	 /**
     * 分页查询
     * @param page
     * @param maintenanceContract
     * @return
     */
    PageInfo<MaintenanceOrder> queryListByPage(Page<MaintenanceOrder> page, MaintenanceOrder maintenanceOrder);

}
