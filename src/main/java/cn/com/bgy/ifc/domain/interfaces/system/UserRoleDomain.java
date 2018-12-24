package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.UserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserRoleDomain {
    /**
     * 查询用户角色列表
     * @param userRole
     * @return
     */
    PageInfo<UserRole> queryPageList(Page page, UserRole userRole);

    /**
     * 查询部门名称
     * @return
     */
    List<String> getDpartmentName();
}
