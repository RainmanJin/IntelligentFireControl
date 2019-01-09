package cn.com.bgy.ifc.service.interfaces.api.project;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台区域信息同步
 * @date: 2018-12-18 20:08
 **/
public interface BgyRegionInfoService {

    /**
     * 碧桂园集成平台区域信息同步
     * @param pageNo
     * @param pageSize
     * @param orgId
     * @return
     */
    ResponseVO<Object> baseObtainBgyRegionInfo(int pageNo, int pageSize, Integer orgId);

    /**
     * 获取集成平台区域信息（全量）
     * @param pageNo
     * @param pageSize
     * @param config
     * @param orgId
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyRegionInfo(int pageNo, int pageSize, ExternalInterfaceConfig config, Integer orgId)throws Exception;

    /**
     * 获取集成平台区域信息（增量）
     * @param pageNo
     * @param pageSize
     * @param config
     * @param createTime
     * @param orgId
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyRegionInfoIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime, Integer orgId)throws Exception;
}
