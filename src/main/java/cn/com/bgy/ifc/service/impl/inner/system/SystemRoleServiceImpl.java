package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.dao.system.SystemRoleDao;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统角色
 * @date: 2018-12-26 17:58
 **/
@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    @Resource
    private SystemRoleDao systemRoleDao;

    @Override
    public SystemRole findById(Long id) {
        return systemRoleDao.findById(id);
    }

    @Override
    public int insert(SystemRole systemRole) {
        systemRole.setLogicRemove(false);
        return systemRoleDao.insert(systemRole);
    }

    @Override
    public int insertSelective(SystemRole systemRole) {
        systemRole.setLogicRemove(false);
        return systemRoleDao.insertSelective(systemRole);
    }

    @Override
    public int update(SystemRole systemRole) {
        return systemRoleDao.update(systemRole);
    }

    @Override
    public int updateSelective(SystemRole systemRole) {
        return systemRoleDao.updateSelective(systemRole);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return systemRoleDao.deleteBatch(ids);
    }
}
