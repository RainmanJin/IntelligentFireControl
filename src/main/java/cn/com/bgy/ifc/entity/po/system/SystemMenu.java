package cn.com.bgy.ifc.entity.po.system;

import java.util.List;

public class SystemMenu {

    private Long id;

    private String name;

    private String imageUrl;

    private String navigateUrl;

    private String remark;

    private Integer sortIndex;

    private Long parentId;

    private Long powerId;

    /**
     * 权限地址
     */
    private String powerUrl;

    /**
     * 所属模块类型
     */
    private Integer type;

    /**
     * 是否选中
     */
    private Boolean checked;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 是否删除
     */
    private Boolean logicRemove;

    /**
     * 子级菜单
     */
    private List<SystemMenu> children;

    private String powerName;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public List<SystemMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SystemMenu> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNavigateUrl() {
        return navigateUrl;
    }

    public void setNavigateUrl(String navigateUrl) {
        this.navigateUrl = navigateUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getPowerId() {
        return powerId;
    }

    public void setPowerId(Long powerId) {
        this.powerId = powerId;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getPowerUrl() {
        return powerUrl;
    }

    public void setPowerUrl(String powerUrl) {
        this.powerUrl = powerUrl;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "SystemMenu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", navigateUrl='" + navigateUrl + '\'' +
                ", remark='" + remark + '\'' +
                ", sortIndex=" + sortIndex +
                ", parentId=" + parentId +
                ", powerId=" + powerId +
                ", powerUrl='" + powerUrl + '\'' +
                ", type=" + type +
                ", checked=" + checked +
                ", logicRemove=" + logicRemove +
                ", children=" + children +
                ", powerName='" + powerName + '\'' +
                '}';
    }
}