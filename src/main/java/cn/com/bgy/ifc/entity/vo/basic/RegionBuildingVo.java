package cn.com.bgy.ifc.entity.vo.basic;

public class RegionBuildingVo {
	/**
	 *集成平台Id
	 */
	private Long id;

	/**
	 *机构表Id，用于区分平台
	 */
	private Long organizationId;

	/**
	 *区域表主键Id
	 */
	private Long regionId;

	/**
	 *项目表主键Id
	 */
	private Long projectId;

	/**
	 *苑区表主键Id
	 */
	private Long courtId;

	/**
	 *
	 */
	private Long streetId;

	public RegionBuildingVo(){
}
	/**
	 *设置集成平台Id
	 *@param: id
	 */
	public void setId(Long id){
		this.id = id;
	}

	/**
	 *获取集成平台Id
	 *@return
	 */
	public Long getId(){
		return id;
	}

	/**
	 *设置机构表Id，用于区分平台
	 *@param: organizationId
	 */
	public void setOrganizationId(Long organizationId){
		this.organizationId = organizationId;
	}

	/**
	 *获取机构表Id，用于区分平台
	 *@return
	 */
	public Long getOrganizationId(){
		return organizationId;
	}

	/**
	 *设置区域表主键Id
	 *@param: regionId
	 */
	public void setRegionId(Long regionId){
		this.regionId = regionId;
	}

	/**
	 *获取区域表主键Id
	 *@return
	 */
	public Long getRegionId(){
		return regionId;
	}

	/**
	 *设置项目表主键Id
	 *@param: projectId
	 */
	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}

	/**
	 *获取项目表主键Id
	 *@return
	 */
	public Long getProjectId(){
		return projectId;
	}

	/**
	 *设置苑区表主键Id
	 *@param: courtId
	 */
	public void setCourtId(Long courtId){
		this.courtId = courtId;
	}

	/**
	 *获取苑区表主键Id
	 *@return
	 */
	public Long getCourtId(){
		return courtId;
	}

	/**
	 *设置
	 *@param: streetId
	 */
	public void setStreetId(Long streetId){
		this.streetId = streetId;
	}

	/**
	 *获取
	 *@return
	 */
	public Long getStreetId(){
		return streetId;
	}

}