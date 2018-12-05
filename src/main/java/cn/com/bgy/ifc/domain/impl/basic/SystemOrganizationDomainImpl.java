package cn.com.bgy.ifc.domain.impl.basic;
import cn.com.bgy.ifc.dao.basic.SystemOrganizationDao;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemOrganizationDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemOrganization;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class SystemOrganizationDomainImpl implements SystemOrganizationDomain {
    @Resource
    private SystemOrganizationDao systemOrganizationDao;
    @Override
    public SystemOrganization findById(Long id) {
        return systemOrganizationDao.findById(id);
    }

    @Override
    public int insert(SystemOrganization systemOrganization) {
        return systemOrganizationDao.insert(systemOrganization);
    }

    @Override
    public int deleteById(Long id) {
        return systemOrganizationDao.deleteById(id);
    }

    @Override
    public int update(SystemOrganization systemOrganization) {
        return systemOrganizationDao.update(systemOrganization);
    }
}
