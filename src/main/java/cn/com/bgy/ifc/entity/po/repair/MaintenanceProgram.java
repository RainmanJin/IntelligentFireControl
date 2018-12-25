package cn.com.bgy.ifc.entity.po.repair;

import java.util.Date;

public class MaintenanceProgram {
    private Long id;

    private Long organizationId;

    private Long regionId;

    private Long equipmentTypeId;

    private Integer cprojectType;

    private Integer orderByNum;

    private String content;

    private String claim;

    private Date createTime;

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
}