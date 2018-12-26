package cn.com.bgy.ifc.entity.vo.maintenance;

import java.util.Date;

public class MaintenanceProgramVo {

    private Long id;

    //组织机构Id
    private Long organizationId;

    private String organizationName;

    //区域ID
    private Long regionId;

    private String regionName;

    //设备类型Id
    private Long equipmentTypeId;

    private String equipmentTypeName;

    //范围类型：1半月维保项目、2季度维保项目、3半年维保项目、4年度维保项目
    private Integer cprojectType;

    //排序编号
    private Integer orderByNum;

    //维保项目（内容）
    private String content;

    //维保基本要求
    private String claim;

    //创建时间
    private Date createTime;

    //是否逻辑删除
    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public Integer getCprojectType() {
        return cprojectType;
    }

    public void setCprojectType(Integer cprojectType) {
        this.cprojectType = cprojectType;
    }

    public Integer getOrderByNum() {
        return orderByNum;
    }

    public void setOrderByNum(Integer orderByNum) {
        this.orderByNum = orderByNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    public void setEquipmentTypeName(String equipmentTypeName) {
        this.equipmentTypeName = equipmentTypeName;
    }
}