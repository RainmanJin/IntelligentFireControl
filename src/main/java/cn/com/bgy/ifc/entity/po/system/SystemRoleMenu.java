package cn.com.bgy.ifc.entity.po.system;

public class SystemRoleMenu {
    /**
     * 系统自增ID
     */
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 系统自增ID
     * @return id 系统自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 系统自增ID
     * @param id 系统自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 角色ID
     * @return role_id 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 菜单ID
     * @return menu_id 菜单ID
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 菜单ID
     * @param menuId 菜单ID
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}