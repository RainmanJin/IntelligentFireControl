package cn.com.bgy.ifc.entity.po.fireinspection;

/**
 * lvbingjian
 * 
 * @author 设施故障检测工作计划（明细） 2019年1月3日11:29:30
 */
public class FirePlanTestDetile {
	private Long id;
	// 设施故障检测工作计划主表ID
	private Long firePlanId;
	// 是否逻辑删除
	private Boolean logicRemove;
	// 消防设施ID
	private Long fireFacilitiesId;
	// 检查情况
	private String situation;
	// 处置结果
	private String result;
	// 设施所属区域表Id
	private Long regionId;
	// 设施所属区域表名称
	private String regionName;
	// 设施所属项目表Id
	private Long projectId;
	// 设施所属项目表名称
	private String projectName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFirePlanId() {
		return firePlanId;
	}

	public void setFirePlanId(Long firePlanId) {
		this.firePlanId = firePlanId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Boolean getLogicRemove() {
		return logicRemove;
	}

	public void setLogicRemove(Boolean logicRemove) {
		this.logicRemove = logicRemove;
	}

	public Long getFireFacilitiesId() {
		return fireFacilitiesId;
	}

	public void setFireFacilitiesId(Long fireFacilitiesId) {
		this.fireFacilitiesId = fireFacilitiesId;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
}