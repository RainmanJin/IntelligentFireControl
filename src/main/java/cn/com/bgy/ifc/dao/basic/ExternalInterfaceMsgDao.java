package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceMsg;

import java.util.List;

public interface ExternalInterfaceMsgDao {

    List<ExternalInterfaceMsg> queryListByParam(ExternalInterfaceMsg record);

    int insert(ExternalInterfaceMsg record);

    int insertSelective(ExternalInterfaceMsg record);
}