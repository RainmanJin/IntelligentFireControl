package cn.com.bgy.ifc.service.interfaces.api.basic;

import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:获取碧桂园集成平台项目信息
 * @date: 2018-12-11 16:23
 **/
public interface BgyProjectService {

    /**
     * @author: ZhangCheng
     * @description:获取集成平台项目信息
     * @param: [pageNo, pageSize, areaId]
     * @return: void
     */
    ResponseVO<Object> baseObtainBgyProject(int pageNo, int pageSize, Integer areaId);

    /**
     * @author: ZhangCheng
     * @description:获取集成平台机构信息（全量）
     * @param: [pageNo, pageSize, areaId]
     * @return: void
     */
    ResponseVO<Object> obtainBgyProject(int pageNo, int pageSize, ExternalInterfaceConfig config, Integer areaId) throws Exception;

    /**
     * @author: ZhangCheng
     * @description:获取集成平台项目信息（增量）
     * @param: [pageNo, pageSize, areaId]
     * @return: void
     */
    ResponseVO<Object> obtainBgyProjectIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime, Integer areaId) throws Exception;

}
