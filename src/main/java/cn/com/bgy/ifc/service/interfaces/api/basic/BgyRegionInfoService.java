package cn.com.bgy.ifc.service.interfaces.api.basic;

import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

public interface BgyRegionInfoService {

    //碧桂园集成平台区域信息同步
    ResponseVO<Object> baseObtainBgyRegionInfo(int pageNo, int pageSize, Integer orgId);

    //获取集成平台区域信息（全量）
    ResponseVO<Object> obtainBgyRegionInfo(int pageNo, int pageSize, ExternalInterfaceConfig config, Integer orgId)throws Exception;

    //获取集成平台区域信息（增量）
    ResponseVO<Object> obtainBgyRegionInfoIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime, Integer orgId)throws Exception;
}
