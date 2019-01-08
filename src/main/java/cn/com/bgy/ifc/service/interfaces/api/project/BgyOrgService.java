package cn.com.bgy.ifc.service.interfaces.api.project;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台机构同步
 * @date: 2018-12-19 18:13
 **/
public interface BgyOrgService {

    /**
     * 碧桂园集成平台机构信息同步
     * @param pageNo
     * @param pageSize
     * @return
     */
    ResponseVO<Object> baseObtainBgyOrg(int pageNo, int pageSize);

    /**
     * 获取集成平台机构信息（全量）
     * @param pageNo
     * @param pageSize
     * @param config
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyOrg(int pageNo, int pageSize, ExternalInterfaceConfig config)throws Exception;

    /**
     * 获取集成平台机构信息（增量）
     * @param pageNo
     * @param pageSize
     * @param config
     * @param createTime
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyOrgIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime)throws Exception;
}
