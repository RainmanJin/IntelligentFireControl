package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMenuDao extends BaseDao<SystemMenu> {

     List<SystemMenu> queryAllSystemMenuInfo(@Param("keyWord") String keyWord);

    /**
     * 查询上级菜单
     * @return
     */
    List<SystemMenu>  queryParentMenu();

    /**
     * 根据角色ID查询菜单权限
     * @param roleId
     * @return
     */
    List<SystemMenu> queryRolePermission(@Param("roleId")Long roleId);

    /**
     * 查询菜单权限
     * @param systemMenu
     * @return
     */
    List<SystemMenu> queryMenuPermission(SystemMenu systemMenu);

}