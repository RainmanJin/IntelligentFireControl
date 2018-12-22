package cn.com.bgy.ifc.entity.vo.system.project;

import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;

/**
 * @Author huxin
 * @Description 机房信息
 * @Date 2018/12/20 15:46
 */
public class RegionComputerRoomVo extends RegionComputerRoom {
    //区域名
    private String regionName;
    //项目名
    private String projectName;
    //苑区名
    private String courtName;
    //街道名
    private String streetName;
    //楼栋名
    private String buildingName;
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName( String streetName ) {
        this.streetName = streetName;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName( String buildingName ) {
        this.buildingName = buildingName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}