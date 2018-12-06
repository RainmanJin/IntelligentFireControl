package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.InterfaceAccount;

public interface InterfaceAccountDomain {

    InterfaceAccount findById(Long id);

    int insert(InterfaceAccount interfaceaccount);

    int deleteById(Long id);

    int update(InterfaceAccount interfaceAccount);
}
