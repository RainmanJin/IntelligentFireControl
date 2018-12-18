package cn.com.bgy.ifc.domain.impl.system.basic;
import cn.com.bgy.ifc.dao.system.basic.SystemOrganizationDao;
import cn.com.bgy.ifc.domain.interfaces.system.basic.SystemOrganizationDomain;
import cn.com.bgy.ifc.entity.po.system.basic.SystemOrganization;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 分页查询
     * @param page
     * @param systemOrganization
     * @return
     */
    @Override
    public PageInfo<SystemOrganization> searchByWhere(Page page, SystemOrganization systemOrganization) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemOrganization> systemOrganizationtList = systemOrganizationDao.searchByWhere(systemOrganization);
        PageInfo<SystemOrganization> pageInfo = new PageInfo<>(systemOrganizationtList);
        return pageInfo;
    }
}
