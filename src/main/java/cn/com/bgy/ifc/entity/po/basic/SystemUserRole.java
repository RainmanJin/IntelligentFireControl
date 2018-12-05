package cn.com.bgy.ifc.entity.po.basic;

import java.util.List;

public class SystemUserRole {
    private Long id;

    private Long roleId;

    private Long userId;

    private List<Account> accountList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}