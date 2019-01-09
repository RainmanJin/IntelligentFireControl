package cn.com.bgy.ifc.service.interfaces.api.fireinspection;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台消防培训同步
 * @date: 2019-01-08 09:23
 **/
public interface BgyFireTaskTrainService {

    /**
     * 碧桂园集成平台消防培训信息同步
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> baseObtainBgyFireTaskTrain(int pageNum, int pageSize);

    /**
     * 获取集成平台消防培训（全量）
     *
     * @param pageNum
     * @param pageSize
     * @param config
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyFireTaskTrain(int pageNum, int pageSize, ExternalInterfaceConfig config) throws Exception;

    /**
     * 获取集成平台消防培训（增量）
     *
     * @param pageNum
     * @param pageSize
     * @param config
     * @param createTime
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyFireTaskTrainIncrement(int pageNum, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception;
}
