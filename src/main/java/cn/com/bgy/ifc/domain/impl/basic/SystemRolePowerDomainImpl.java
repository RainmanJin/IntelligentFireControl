package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.AccountDao;
import cn.com.bgy.ifc.dao.basic.SystemRolePowerDao;
import cn.com.bgy.ifc.domain.interfaces.basic.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemRolePowerDomain;
import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.SystemRolePower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemRolePowerDomainImpl implements SystemRolePowerDomain {
    @Resource
    private SystemRolePowerDao systemRolePowerDao;

    @Override
    public int save(SystemRolePower systemRolePower) {
        return systemRolePowerDao.insert(systemRolePower);
    }

    @Override
    public List<SystemRolePower> searchByWhere(SystemRolePower systemRolePower) {
        return systemRolePowerDao.searchByWhere(systemRolePower);
    }

    @Override
    public PageInfo<SystemRolePower> searchByPage(Page page, SystemRolePower systemRolePower) {
        page=PageHelper.startPage(page.getPageNum(),page.getPageSize(),page.getOrderBy());
        List<SystemRolePower> systemRolePowerList=this.searchByWhere(systemRolePower);
        PageInfo<SystemRolePower> pageInfo=new PageInfo<>(systemRolePowerList);
        return pageInfo;
    }

    @Override
    public int deleteById(Long id) {
        return systemRolePowerDao.deleteById(id);
    }

    @Override
    public SystemRolePower findById(Long id) {
        return systemRolePowerDao.findById(id);
    }

    @Override
    public int updateById(SystemRolePower systemRolePower) {
        return systemRolePowerDao.updateById(systemRolePower);
    }


}
