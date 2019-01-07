package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.dao.system.SystemUserRoleDao;
import cn.com.bgy.ifc.domain.interfaces.system.SystemUserRoleDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemUserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SystemUserRoleDomainImpl implements SystemUserRoleDomain {
    @Resource
    private SystemUserRoleDao systemUserRoleDao;

    @Override
    public int save(SystemUserRole systemUserRole) {
        int res=systemUserRoleDao.deleteByUserId(systemUserRole.getUserId());
        if(systemUserRole.getRoleId()==null){
           return 1;
        }
        return systemUserRoleDao.insert(systemUserRole);
    }

    @Override
    public List<Map<String,Object>> searchByWhere(Account account) {
        return systemUserRoleDao.searchByWhere(account);
    }

    @Override
    public PageInfo<Map<String,Object>> searchByPage(Page page, Account account) {
        page=PageHelper.startPage(page.getPageNum(),page.getPageSize(),page.getOrderBy());
        List<Map<String,Object>> systemUserRoleList=this.searchByWhere(account);
        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(systemUserRoleList);
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
