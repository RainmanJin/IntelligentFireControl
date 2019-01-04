package cn.com.bgy.ifc.domain.interfaces.maintenance;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrder;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.maintenance.BgyMaintenanceWorkOrderVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 维保工单业务
 *
 * @author lvbingjian
 * date 2018年12月26日15:23:39
 */
public interface MaintenanceOrderDomain extends BaseDomain<MaintenanceOrder> {
    /**
     * 分页查询
     *
     * @param page
     * @param
     * @return
     */
    PageInfo<MaintenanceOrder> queryListByPage(Page<MaintenanceOrder> page, MaintenanceOrder maintenanceOrder);

    /**
     * @author: ZhangCheng
     * @description:集成平台全量获取维保工单信息（全量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> saveBgyMaintenanceWorkOrder(List<BgyMaintenanceWorkOrderVo> list, Long orgId);

    /**
     * @author: ZhangCheng
     * @description:集成平台增量获取维保工单信息（增量）
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> alterBgyMaintenanceWorkOrder(List<BgyMaintenanceWorkOrderVo> list, Long orgId);

}
