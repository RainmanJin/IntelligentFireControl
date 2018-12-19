package cn.com.bgy.ifc.domain.impl.system.user;

import cn.com.bgy.ifc.dao.system.user.UserRoleDao;
import cn.com.bgy.ifc.domain.interfaces.system.user.UserRoleDomain;
import cn.com.bgy.ifc.entity.po.system.user.UserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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

    /**
     * 查询部门名称
     * @return
     */
    @Override
    public List<String> getDpartmentName() {
        return userRoleDao.getDpartmentName();
    }
}
