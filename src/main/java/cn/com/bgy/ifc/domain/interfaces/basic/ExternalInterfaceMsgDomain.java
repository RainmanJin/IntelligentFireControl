package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceMsg;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-11 09:05
 **/
public interface ExternalInterfaceMsgDomain {

    List<ExternalInterfaceMsg> queryListByParam(ExternalInterfaceMsg record);

    int insert(ExternalInterfaceMsg record);

    int insertSelective(ExternalInterfaceMsg record);
}
