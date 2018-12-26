package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.dao.system.SystemOrganizationDao;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:机构管理
 * @date: 2018-12-26 10:53
 **/
@Service
public class SystemOrganizationServiceImpl implements SystemOrganizationService {

    @Resource
    private SystemOrganizationDao systemOrganizationDao;

    @Override
    public SystemOrganization findById(Long id) {
        return systemOrganizationDao.findById(id);
    }

    @Override
    public int insert(SystemOrganization systemOrganization) {
        systemOrganization.setCreateTime(new Date());
        systemOrganization.setLogicRemove(false);
        return systemOrganizationDao.insert(systemOrganization);
    }

    @Override
    public int insertSelective(SystemOrganization systemOrganization) {
        systemOrganization.setCreateTime(new Date());
        systemOrganization.setLogicRemove(false);
        return systemOrganizationDao.insertSelective(systemOrganization);
    }

    @Override
    public int update(SystemOrganization systemOrganization) {
        systemOrganization.setCreateTime(new Date());
        return systemOrganizationDao.update(systemOrganization);
    }

    @Override
    public int updateSelective(SystemOrganization systemOrganization) {
        systemOrganization.setCreateTime(new Date());
        return systemOrganizationDao.updateSelective(systemOrganization);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return systemOrganizationDao.deleteBatch(ids);
    }
}
