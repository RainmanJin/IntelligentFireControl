package cn.com.bgy.ifc.entity.vo.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionProject;

public class RegionProjectVo extends RegionProject {

    /**
     * @Author huxin
     * @Description 区域ID
     * @Date 2018/12/18 17:54
     */
    private Long regionId;
    //区域名
    private String regionName;
    /**
     * @Author huxin
     * @Description 关键字
     * @Date 2018/12/18 20:23
     */
    private  String keyword;

    @Override
    public Long getRegionId() {
        return regionId;
    }

    @Override
    public void setRegionId( Long regionId ) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName( String regionName ) {
        this.regionName = regionName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}