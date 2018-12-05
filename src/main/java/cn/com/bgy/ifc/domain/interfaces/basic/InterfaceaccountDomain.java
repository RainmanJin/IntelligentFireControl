package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Interfaceaccount;

public interface InterfaceaccountDomain {

    Interfaceaccount findById(Long id);

    int insert(Interfaceaccount interfaceaccount);

    int deleteById(Long id);

    int update(Interfaceaccount interfaceaccount);
}
