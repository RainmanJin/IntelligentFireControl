package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceMsg;

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
}
