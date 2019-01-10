package cn.com.bgy.ifc.domain.interfaces.repair;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.repair.RepairOrder;

/**
 * @Author huxin
 * @Date 2018/12/26 16:50
 * @Description 招修工单Domian
 **/

public interface RepairOrderDomain extends BaseDomain<RepairOrder> {


    int launchRepair( RepairOrder repairOrder );
}
