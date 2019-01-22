package cn.com.bgy.ifc.entity.po.synchro;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台街道数据实体,用于数据同步
 * @date: 2019-01-22 10:57
 **/
public class BgyRegionStreet {

    /**
     * 街道ID
     */
    private Long id;
    /**
     * 平台ID
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
     * 街道名
     */
    private String name;
    /**
     * 创建修改时间
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
