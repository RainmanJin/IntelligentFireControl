package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.ExternalInterfaceConfigDao;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部接口配置
 * @date: 2018-12-10 18:16
 **/
@Service
public class ExternalInterfaceConfigDomainImpl implements ExternalInterfaceConfigDomain {

    @Resource
    private ExternalInterfaceConfigDao externalInterfaceConfigDao;
    @Override
    public List<ExternalInterfaceConfig> queryListByParam(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.queryListByParam(record);
    }

    @Override
    public ExternalInterfaceConfig findById(Long id) {
        return externalInterfaceConfigDao.findById(id);
    }

    @Override
    public int insert(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.insert(record);
    }

    @Override
    public int insertSelective(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.insertSelective(record);
    }

    @Override
    public int update(ExternalInterfaceConfig record) {
        return externalInterfaceConfigDao.update(record);
    }
}
