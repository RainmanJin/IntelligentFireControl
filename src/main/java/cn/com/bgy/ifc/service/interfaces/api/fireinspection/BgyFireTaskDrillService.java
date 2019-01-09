package cn.com.bgy.ifc.service.interfaces.api.fireinspection;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台消防演练同步
 * @date: 2019-01-08 09:25
 **/
public interface BgyFireTaskDrillService {

    /**
     * 碧桂园集成平台消防演练信息同步
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVO<Object> baseObtainBgyFireTaskDrill(int pageNum, int pageSize);

    /**
     * 获取集成平台消防演练（全量）
     *
     * @param pageNum
     * @param pageSize
     * @param config
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyFireTaskDrill(int pageNum, int pageSize, ExternalInterfaceConfig config) throws Exception;

    /**
     * 获取集成平台消防演练（增量）
     *
     * @param pageNum
     * @param pageSize
     * @param config
     * @param createTime
     * @return
     * @throws Exception
     */
    ResponseVO<Object> obtainBgyFireTaskDrillIncrement(int pageNum, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception;
}
