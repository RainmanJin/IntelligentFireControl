package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceMsg;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部接入接口日志
 * @date: 2018-12-11 09:05
 **/
public interface ExternalInterfaceMsgDomain {

    /**
     * 外部接入接口日志查询
     * @param record
     * @return
     */
    List<ExternalInterfaceMsg> queryListByParam(ExternalInterfaceMsg record);

    /**
     * 获取外部接入接口对应日志
     * @param msgTypeValue
     * @param orgId
     * @return
     */
    List<ExternalInterfaceMsg> queryBgyInterfaceMsg(Integer msgTypeValue,Long orgId);

    /**
     * 添加外部接入接口日志
     * @param record
     * @return
     */
    int insert(ExternalInterfaceMsg record);

    /**
     * 添加外部接入接口日志
     * @param record
     * @return
     */
    int insertSelective(ExternalInterfaceMsg record);

    /**
     * 碧桂园集成平台全量新增成功接口日志
     * @param orgId
     * @param msgType
     * @param totalCount
     * @return
     */
    int successInterfaceMsg(Long orgId,Integer msgType,Integer totalCount);

    /**
     * 碧桂园集成平台增量新增成功接口日志
     * @param orgId
     * @param msgType
     * @param totalCount
     * @param addCount
     * @param updateCount
     * @param deleteCount
     * @return
     */
    int alterInterfaceMsg(Long orgId,Integer msgType,Integer totalCount,Integer addCount,Integer updateCount,Integer deleteCount);
}
