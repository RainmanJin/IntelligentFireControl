package cn.com.bgy.ifc.entity.po.project;

import java.util.Date;

/**
 * @Author huxin
 * @Description 楼栋单元信息
 * @Date 2018/12/20 9:10
 */
public class RegionBuilding {
    /**
     * 楼栋ID
     */
    private Long id;
    /**
     * 集成平台ID
     */
    private Long organizationId;
    /**
     * 区域ID
     */
    private Long regionId;
    /**
     * 项目ID
     */
    private Long projectId;
    /**
     * 苑区ID
     */
    private Long courtId;
    /**
     * 街道ID
     */
    private Long streetId;
    /**
     * 楼栋名
     */
    private String name;
    /**
     * 创建、修改时间
     */
    private Date createTime;
    /**
     * 逻辑删除
     */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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