package cn.com.bgy.ifc.service.interfaces.api.repair;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台维保公司
 * @date: 2018-12-24 10:07
 **/
public interface BgyRepairCompanyService {

    /**
     * @author: ZhangCheng
     * @description:碧桂园集成平台维保公司信息同步
     * @param: [pageNo, pageSize]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> baseObtainBgyRepairCompany(int pageNo, int pageSize);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台维保公司（全量）
     * @param: [pageNo, pageSize, config]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyRepairCompany(int pageNo, int pageSize, ExternalInterfaceConfig config)throws Exception;

    /**
     * @author: ZhangCheng
     * @description:获取集成平台维保公司（增量）
     * @param: [pageNo, pageSize, config, createTime]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> obtainBgyRepairCompanyIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime)throws Exception;
}
