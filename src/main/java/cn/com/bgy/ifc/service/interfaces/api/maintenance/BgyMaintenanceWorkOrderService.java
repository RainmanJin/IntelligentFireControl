package cn.com.bgy.ifc.service.interfaces.api.maintenance;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台维保工单
 * @date: 2018-12-28 14:24
 **/
public interface BgyMaintenanceWorkOrderService {

    /**
     * @author: ZhangCheng
     * @description:碧桂园集成平台维保工单信息同步
     * @param: [pageNo, pageSize]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> baseObtainBgyMaintenanceWorkOrder(int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台维保工单（全量）
     * @param: [pageNo, pageSize, config]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyMaintenanceWorkOrder(int pageNo, int pageSize, ExternalInterfaceConfig config)throws Exception;

    /**
     * @author: ZhangCheng
     * @description:获取集成平台维保工单（增量）
     * @param: [pageNo, pageSize, config, createTime]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyMaintenanceWorkOrderIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime)throws Exception;
}
