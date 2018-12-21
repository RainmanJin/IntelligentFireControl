package cn.com.bgy.ifc.entity.vo.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionBuilding;
/**
 * @Author huxin
 * @Description 楼栋单元扩展字段
 * @Date 2018/12/20 16:39
 */
public class RegionBuildingVo extends RegionBuilding {
	//区域名
	private String regionName;
	//项目名
	private String projectName;
	//苑区名
	private String courtName;
	//街道名
	private String streetName;
	//关键字查询
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword( String keyword ) {
		this.keyword = keyword;
	}
}