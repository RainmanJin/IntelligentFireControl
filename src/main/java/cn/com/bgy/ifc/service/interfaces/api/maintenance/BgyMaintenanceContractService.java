package cn.com.bgy.ifc.service.interfaces.api.maintenance;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台维保合同
 * @date: 2018-12-28 14:30
 **/
public interface BgyMaintenanceContractService {

    /**
     * @author: ZhangCheng
     * @description:碧桂园集成平台维保合同信息同步
     * @param: [pageNo, pageSize]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> baseObtainBgyRepairContract(int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台维保合同（全量）
     * @param: [pageNo, pageSize, config]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyRepairContract(int pageNo, int pageSize, ExternalInterfaceConfig config)throws Exception;

    /**
     * @author: ZhangCheng
     * @description:获取集成平台机维保合同（增量）
     * @param: [pageNo, pageSize, config, createTime]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyRepairContractIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime)throws Exception;
}
