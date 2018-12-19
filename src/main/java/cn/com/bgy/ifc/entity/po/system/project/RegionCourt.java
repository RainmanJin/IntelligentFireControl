package cn.com.bgy.ifc.entity.po.system.project;

import java.util.Date;

public class RegionCourt {
    /**
     * @Author huxin
     * @Description id
     * @Date 2018/12/19 11:30
     */
    private Long id;
    /**
     * @Author huxin
     * @Description 平台ID
     * @Date 2018/12/19 11:31
     */
    private Long organizationId;
    /**
     * @Author huxin
     * @Description 区域id
     * @Date 2018/12/19 11:31
     */
    private Long regionId;
    /**
     * @Author huxin
     * @Description 项目id
     * @Date 2018/12/19 11:31
     */
    private Long projectId;
    /**
     * @Author huxin
     * @Description 苑区名
     * @Date 2018/12/19 11:31
     */
    private String name;
    /**
     * @Author huxin
     * @Description 创建、修改时间
     * @Date 2018/12/19 11:32
     */
    private Date createTime;
    /**
     * @Author huxin
     * @Description 逻辑删除：0存在 1 删除
     * @Date 2018/12/19 11:38
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
}