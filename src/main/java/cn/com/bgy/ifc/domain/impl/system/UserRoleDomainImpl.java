package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.dao.system.UserRoleDao;
import cn.com.bgy.ifc.domain.interfaces.system.UserRoleDomain;
import cn.com.bgy.ifc.entity.po.system.UserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleDomainImpl implements UserRoleDomain {
    @Resource
    private UserRoleDao userRoleDao;

    /**
     * 分页查询用户角色
     * @param page
     * @param userRole
     * @return
     */
    @Override
    public PageInfo<UserRole> queryPageList(Page page, UserRole userRole) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<UserRole> userRoleList = userRoleDao.queryPageList(userRole);
        PageInfo<UserRole> pageInfo = new PageInfo<>(userRoleList);
        return pageInfo;
    }

    @Override
    public List<UserRole> queryListByParam(UserRole userRole) {
        return userRoleDao.queryPageList(userRole);
    }

    @Override
    public List<UserRole> queryListByMap(Map<String, Object> map) {
        return userRoleDao.queryListByMap(map);
    }

    @Override
    public UserRole findById(Long id) {
        return userRoleDao.findById(id);
    }

    @Override
    public int insert(UserRole userRole) {
        return userRoleDao.insert(userRole);
    }

    @Override
    public int insertSelective(UserRole userRole) {
        return userRoleDao.insertSelective(userRole);
    }

    @Override
    public int update(UserRole userRole) {
        return userRoleDao.update(userRole);
    }

    @Override
    public int updateSelective(UserRole userRole) {
        return userRoleDao.updateSelective(userRole);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return userRoleDao.deleteBatch(ids);
    }
}
