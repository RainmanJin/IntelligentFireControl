package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceMsg;

public interface ExternalInterfaceMsgDao {
    int insert(ExternalInterfaceMsg record);

    int insertSelective(ExternalInterfaceMsg record);
}