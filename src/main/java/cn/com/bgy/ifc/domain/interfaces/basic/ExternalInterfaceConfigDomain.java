package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部接口配置
 * @date: 2018-12-10 18:10
 **/
public interface ExternalInterfaceConfigDomain {

    List<ExternalInterfaceConfig> queryListByParam(ExternalInterfaceConfig record);

    ExternalInterfaceConfig findById(Long id);

    int insert(ExternalInterfaceConfig record);

    int insertSelective(ExternalInterfaceConfig record);

    int update(ExternalInterfaceConfig record);
}
