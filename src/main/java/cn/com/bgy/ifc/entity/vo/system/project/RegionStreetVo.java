package cn.com.bgy.ifc.entity.vo.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionStreet;

/**
 * @Author huxin
 * @Date 2018/12/19 17:38
 * @Description 街道信息扩展字段
 **/

public class RegionStreetVo extends RegionStreet {

    //区域名字
    private String regionName;
    //项目名
    private String projectName;
    //苑区名
    private String courtName;
    //关键字
    private String keyword;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName( String regionName ) {
        this.regionName = regionName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName( String projectName ) {
        this.projectName = projectName;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName( String courtName ) {
        this.courtName = courtName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}
