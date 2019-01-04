package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.dao.system.SystemRoleDao;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRoleDomain;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.vo.system.SystemRoleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:系统角色
 * @date: 2018-12-05 11:00
 **/
@Service
public class SystemRoleDomainImpl  implements SystemRoleDomain {

    @Resource
    private SystemRoleDao systemRoleDao;

    @Override
    public List<SystemRole> queryListByParam(SystemRole record) {
        return systemRoleDao.queryListByParam(record);
    }
    @Override
    public List<SystemRole> queryAllList(SystemRoleVo record) {
        return systemRoleDao.queryAllList(record);
    }
    @Override
    public List<SystemRole> queryListByMap(Map<String, Object> map) {
        return systemRoleDao.queryListByMap(map);
    }

    @Override
    public SystemRole findById(Long id) {
        return systemRoleDao.findById(id);
    }

    /**
     * @Author huxin
     * @Description 添加系统角色
     * @Date 2018/12/17 14:39
     */
    @Transactional
    @Override
    public int insert(SystemRole record) {
        record.setLogicRemove(true);
        record.setOrganizationId(1L);
        record.setState(0);
        return systemRoleDao.insert(record);
    }

    @Override
    public int insertSelective(SystemRole systemRole) {
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


    /**
     * 根据登录用户查询系统角色（下拉展示）
     * @param userId
     * @return
     */
    @Override
    public List<SystemRole> queryListByUserId(Long userId) {
        return systemRoleDao.queryListByUserId(userId);
    }


}
