package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部接入接口配置
 * @date: 2018-12-10 18:10
 **/
public interface ExternalInterfaceConfigDomain {

    /**
     * 查询集成平台接口信息
     * @return
     */
    List<ExternalInterfaceConfig> queryIntegrationConfig();

    /**
     * 查询物联网设备接口信息
     * @return
     */
    List<ExternalInterfaceConfig> queryInternetThingConfig();

    int insertSelective(ExternalInterfaceConfig record);
}
