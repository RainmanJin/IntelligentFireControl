package cn.com.bgy.ifc.entity.po.basic;

public class RegionCourt{
	/**
	 *集成平台Id
	 */
	private Long id;

	/**
	 *机构表id，用于区分平台
	 */
	private Long organizationId;

	/**
	 *区域表主键id
	 */
	private Long regionId;

	/**
	 *项目表主键id
	 */
	private Long projectId;

	/**
	 *项目名称
	 */
	private String name;

	/**
	 *创建、修改时间
	 */
	private java.util.Date createTime;

	/**
	 *
	 */
	private int logicRemove;

	public RegionCourt(){
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
	 *设置机构表id，用于区分平台
	 *@param: organizationId
	 */
	public void setOrganizationId(Long organizationId){
		this.organizationId = organizationId;
	}

	/**
	 *获取机构表id，用于区分平台
	 *@return
	 */
	public Long getOrganizationId(){
		return organizationId;
	}

	/**
	 *设置区域表主键id
	 *@param: regionId
	 */
	public void setRegionId(Long regionId){
		this.regionId = regionId;
	}

	/**
	 *获取区域表主键id
	 *@return
	 */
	public Long getRegionId(){
		return regionId;
	}

	/**
	 *设置项目表主键id
	 *@param: projectId
	 */
	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}

	/**
	 *获取项目表主键id
	 *@return
	 */
	public Long getProjectId(){
		return projectId;
	}

	/**
	 *设置项目名称
	 *@param: name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 *获取项目名称
	 *@return
	 */
	public String getName(){
		return name;
	}

	/**
	 *设置创建、修改时间
	 *@param: createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}

	/**
	 *获取创建、修改时间
	 *@return
	 */
	public java.util.Date getCreateTime(){
		return createTime;
	}

	/**
	 *设置
	 *@param: logicRemove
	 */
	public void setLogicRemove(int logicRemove){
		this.logicRemove = logicRemove;
	}

	/**
	 *获取
	 *@return
	 */
	public int getLogicRemove(){
		return logicRemove;
	}

}