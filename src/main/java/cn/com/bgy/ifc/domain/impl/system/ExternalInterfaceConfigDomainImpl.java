package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.dao.system.ExternalInterfaceConfigDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部接入接口配置
 * @date: 2018-12-10 18:16
 **/
@Service
public class ExternalInterfaceConfigDomainImpl implements ExternalInterfaceConfigDomain {

    @Resource
    private ExternalInterfaceConfigDao externalInterfaceConfigDao;


    @Override
    public List<ExternalInterfaceConfig> queryIntegrationConfig() {
        ExternalInterfaceConfig record=new ExternalInterfaceConfig();
        record.setPlatformValue(ExternalConstant.PlatformValue.INTEGERATED_PLATFORM.getValue());
        record.setState(SystemConstant.EnableState.ENABLE.getValue());
        record.setLogicRemove(false);
        return externalInterfaceConfigDao.queryListByParam(record);
    }

    @Override
    public int insertSelective(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.insertSelective(record);
    }

}
