package cn.com.bgy.ifc.entity.vo.system.project;

import cn.com.bgy.ifc.entity.po.project.RegionCourt;
/**
 * @Author huxin
 * @Description 苑区信息扩展字段
 * @Date 2018/12/19 15:48
 */
public class RegionCourtVo extends RegionCourt {




    /**
     * @Author huxin
     * @Description 区域名
     * @Date 2018/12/19 15:39
     */
    private String regionName;
    /**
     * @Author huxin
     * @Description 项目名
     * @Date 2018/12/19 15:39
     */
    private String projectName;
    /**
     * @Author huxin
     * @Description 苑区名
     * @Date 2018/12/19 11:31
     */
    private String name;

    /**
     * @Author huxin
     * @Description 查询关键字
     * @Date 2018/12/19 11:33
     */
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName( String name ) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}