package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.SystemRoleMenu;

import java.util.List;

public interface SystemRoleMenuDao extends BaseDao<SystemRoleMenu> {

    /**
     * 批量更新角色菜单权限
     * @param list
     * @return
     */
    int insertList(List<SystemRoleMenu> list);

    /**
     * 根据角色ID删除关联数据
     * @param roleId
     * @return
     */
    int deleteRoleMenu(Long roleId);

}