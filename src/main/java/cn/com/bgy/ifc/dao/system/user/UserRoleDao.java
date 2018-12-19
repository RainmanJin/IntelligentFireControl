package cn.com.bgy.ifc.dao.system.user;

import cn.com.bgy.ifc.entity.po.system.user.UserRole;

import java.util.List;

public interface UserRoleDao {
    /**
     * 查询用户角色列表
     * @param userRole
     * @return
     */
    List<UserRole> queryPageList(UserRole userRole);

    /**
     * 查询部门名称
     * @return
     */
    List<String> getDpartmentName();
}
