package cn.com.bgy.ifc.entity.vo.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SystemMenuVo {
    private Long id;

    /**
     * 菜单名称
     */
    @NotBlank(message="菜单名称不能为空！")
    @Size(max=50,message="菜单名称长度不能超过50字符！")
    private String name;

    @NotBlank(message="菜单图标不能为空！")
    @Size(max=500,message="菜单图标长度不能超过500字符！")
    private String imageUrl;

    @NotBlank(message="菜单地址不能为空！")
    @Size(max=500,message="菜单地址长度不能超过500字符！")
    private String navigateUrl;

    private String remark;

    private String oneLabelName;

    private String twoLabelName;

    /**
     * 顺序编号
     */
    @NotNull(message="顺序编号不能为空！")
    private Integer sortIndex;

    /**
     * 上级菜单Id
     */
    private Long parentId;

    /**
     * 系统权限表Id
     */
    private Long powerId;

    private String powerName;

    private Integer type;

    /**
     * @Author chenlie
     * 角色值
     */
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOneLabelName() {
        return oneLabelName;
    }

    public void setOneLabelName(String oneLabelName) {
        this.oneLabelName = oneLabelName;
    }

    public String getTwoLabelName() {
        return twoLabelName;
    }

    public void setTwoLabelName(String twoLabelName) {
        this.twoLabelName = twoLabelName;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    private Boolean logicRemove;

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
}