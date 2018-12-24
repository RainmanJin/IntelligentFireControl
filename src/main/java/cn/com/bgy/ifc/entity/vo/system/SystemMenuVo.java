package cn.com.bgy.ifc.entity.vo.system;

public class SystemMenuVo {
    private Long id;

    private String name;

    private String imageUrl;

    private String navigateUrl;

    private String remark;

    private String oneLabelName;

    private String twoLabelName;

    private String treeLabelName;

    private Integer sortIndex;

    private Long parentId;

    private Long powerId;

    private String powerName;

    private Integer type;


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

    public String getTreeLabelName() {
        return treeLabelName;
    }

    public void setTreeLabelName(String treeLabelName) {
        this.treeLabelName = treeLabelName;
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