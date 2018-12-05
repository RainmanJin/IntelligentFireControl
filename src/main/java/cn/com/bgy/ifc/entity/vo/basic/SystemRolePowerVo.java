package cn.com.bgy.ifc.entity.vo.basic;

import javax.validation.constraints.NotNull;

public class SystemRolePowerVo {
    /**
     *系统自增Id
     */
    private Long id;

    /**
     *系统角色ID
     */
    @NotNull(message="系统角色ID不能为空")
    private Long roleId;

    /**
     *系统权限ID
     */
    @NotNull(message="系统权限ID不能为空")
    private Long powerId;

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

    public Long getPowerId() {
        return powerId;
    }

    public void setPowerId(Long powerId) {
        this.powerId = powerId;
    }
}