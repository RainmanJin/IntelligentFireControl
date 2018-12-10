package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;

public interface ExternalInterfaceConfigDao {
    int insert(ExternalInterfaceConfig record);

    int insertSelective(ExternalInterfaceConfig record);
}