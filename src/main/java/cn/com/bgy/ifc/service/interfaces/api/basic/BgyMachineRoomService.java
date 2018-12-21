package cn.com.bgy.ifc.service.interfaces.api.basic;

import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台机房信息同步
 * @date: 2018-12-19 19:25
 **/
public interface BgyMachineRoomService {

    //碧桂园集成平台机房信息同步
    ResponseVO<Object> baseObtainBgyMachineRoom(int pageNo, int pageSize);

    //获取集成平台机房信息（全量）
    ResponseVO<Object> obtainBgyMachineRoom(int pageNo, int pageSize, ExternalInterfaceConfig config)throws Exception;

    //获取集成平台机房信息（增量）
    ResponseVO<Object> obtainBgyMachineRoomIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime)throws Exception;
}
