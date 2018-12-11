package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;

import java.util.List;

public interface ExternalInterfaceConfigDao {

    List<ExternalInterfaceConfig> queryListByParam(ExternalInterfaceConfig record);

    ExternalInterfaceConfig findById(Long id);

    int insert(ExternalInterfaceConfig record);

    int insertSelective(ExternalInterfaceConfig record);

    int update(ExternalInterfaceConfig record);
}