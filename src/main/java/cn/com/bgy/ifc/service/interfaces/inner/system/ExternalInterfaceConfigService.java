package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:接入接口配置
 * @date: 2018-12-27 11:08
 **/
public interface ExternalInterfaceConfigService extends BaseService<ExternalInterfaceConfig> {

    /**
     * @author: ZhangCheng
     * @description:分页查询接入接口配置
     * @param: [page, platformValue]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig>
     */
    PageInfo<ExternalInterfaceConfig> queryListByPage(Page<ExternalInterfaceConfig> page, Integer platformValue);


}
