package cn.com.bgy.ifc.entity.po.system.project;

import java.io.Serializable;
import java.util.Date;

public class RegionComputerRoom implements Serializable {
    //机房id
    private Long id;
    //平台id
    private Long organizationId;
    //区域id
    private Long regionId;
    //项目id
    private Long projectId;
    //苑区id
    private Long courtId;
    //街道id
    private Long streetId;
    //楼栋id
    private Long buildingId;
    //机房名称
    private String name;
    //机房编码
    private String code;

    /**
     * 地址信息描述(苑区/街道/楼栋)，各部分可能为空
     */
    private String description;
    //创建、修改时间
    private Date createTime;
    //逻辑删除 0 存在 1 删除
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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