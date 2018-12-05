package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.SystemRoleDao;
import cn.com.bgy.ifc.domain.interfaces.basic.RoleDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemPower;
import cn.com.bgy.ifc.entity.po.basic.SystemRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统角色
 * @date: 2018-12-05 11:00
 **/
@Service
public class RoleDomainImpl implements RoleDomain {

    @Resource
    private SystemRoleDao systemRoleDao;

    @Override
    public SystemRole findById(Long id) {
        return systemRoleDao.findById(id);
    }

    @SuppressWarnings("UnusedAssignment")
    @Override
    public PageInfo<SystemRole> queryListByPage(Page<SystemRole> page, SystemRole record) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemRole> list = systemRoleDao.queryListByParam(record);
        return new PageInfo<SystemRole>(list);
    }

    @Override
    public List<SystemRole> queryListByParam(SystemRole record) {
        return systemRoleDao.queryListByParam(record);
    }

    @Transactional
    @Override
    public int insert(SystemRole record) {
        record.setLogicRemove(false);
        return systemRoleDao.insert(record);
    }

    @Transactional
    @Override
    public int update(SystemRole record) {
        return systemRoleDao.update(record);
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        return systemRoleDao.deleteById(id);
    }
}
