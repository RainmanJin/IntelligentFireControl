package cn.com.bgy.ifc.entity.po.project;

import java.io.Serializable;
import java.util.Date;

public class RegionCourt implements Serializable {
    /**
     * id
     */
    private Long id;
    /**
     * 平台ID
     */
    private Long organizationId;
    /**
     * 区域id
     */
    private Long regionId;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 苑区名
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

    @Override
    public String toString() {
        return "RegionCourt{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", regionId=" + regionId +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", logicRemove=" + logicRemove +
                '}';
    }
}