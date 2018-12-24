package cn.com.bgy.ifc.entity.vo.project;

import java.util.Date;

/**
 * @Author huxin
 * @Date 2018/12/19 17:38
 * @Description 街道信息Vo
 **/

public class RegionStreetVo  {

    //街道ID
    private Long id;
    //平台ID
    private Long organizationId;
    //区域ID
    private Long regionId;
    //项目ID
    private Long projectId;
    //苑区ID
    private Long courtId;
    //街道名
    private String name;
    //创建修改时间
    private Date createTime;
    //逻辑删除 0表示存在 1表示删除
    private Boolean logicRemove;
    //关键字
    private String keyword;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId( Long organizationId ) {
        this.organizationId = organizationId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId( Long regionId ) {
        this.regionId = regionId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId( Long projectId ) {
        this.projectId = projectId;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId( Long courtId ) {
        this.courtId = courtId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime( Date createTime ) {
        this.createTime = createTime;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}
