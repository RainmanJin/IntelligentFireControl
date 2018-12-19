package cn.com.bgy.ifc.entity.vo.system.project;

import java.util.Date;

/**
 * @Author huxin
 * @Date 2018/12/19 17:38
 * @Description 街道信息Vo
 **/

public class RegionStreetVo {
    //街道ID
    private Long id;
    //平台Id
    private Long organizationId;

    //区域ID
    private Long regionId;
    //区域名字
    private String regionName;
    //项目ID
    private Long projectId;
    //项目名
    private String projectName;
    //苑区ID
    private Long courtId;
    //苑区名
    private String courtName;
    //街道名字
    private String name;
    //创建、修改时间
    private Date createTime;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName( String regionName ) {
        this.regionName = regionName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId( Long projectId ) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName( String projectName ) {
        this.projectName = projectName;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId( Long courtId ) {
        this.courtId = courtId;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName( String courtName ) {
        this.courtName = courtName;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}
