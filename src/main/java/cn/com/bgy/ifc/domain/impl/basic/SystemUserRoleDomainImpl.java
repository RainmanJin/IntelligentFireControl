package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.SystemUserRoleDao;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemUserRoleDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemUserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemUserRoleDomainImpl implements SystemUserRoleDomain {
    @Resource
    private SystemUserRoleDao systemUserRoleDao;

    @Override
    public int save(SystemUserRole systemUserRole) {
        return systemUserRoleDao.insert(systemUserRole);
    }

    @Override
    public List<SystemUserRole> searchByWhere(SystemUserRole systemUserRole) {
        return systemUserRoleDao.searchByWhere(systemUserRole);
    }

    @Override
    public PageInfo<SystemUserRole> searchByPage(Page page, SystemUserRole systemUserRole) {
        page=PageHelper.startPage(page.getPageNum(),page.getPageSize(),page.getOrderBy());
        List<SystemUserRole> systemUserRoleList=this.searchByWhere(systemUserRole);
        PageInfo<SystemUserRole> pageInfo=new PageInfo<>(systemUserRoleList);
        return pageInfo;
    }

    @Override
    public int deleteById(Long id) {
        return systemUserRoleDao.deleteById(id);
    }

    @Override
    public SystemUserRole findById(Long id) {
        return systemUserRoleDao.findById(id);
    }

    @Override
    public int updateById(SystemUserRole systemUserRole) {
        return systemUserRoleDao.updateById(systemUserRole);
    }


}
