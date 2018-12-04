package cn.com.bgy.ifc.entity.vo.basic;

public class RegionInfoVo {
	/**
	 *集成平台Id
	 */
	private Long id;

	/**
	 *机构表Id，用于区分平台
	 */
	private Long organizationId;

	/**
	 *区域编码
	 */
	private String code;

	/**
	 *区域名称
	 */
	private String name;

	/**
	 *创建、修改时间
	 */
	private java.util.Date createTime;

	/**
	 *是否逻辑删除
	 */
	private int logicRemove;

	public RegionInfoVo(){
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
	 *设置区域编码
	 *@param: code
	 */
	public void setCode(String code){
		this.code = code;
	}

	/**
	 *获取区域编码
	 *@return
	 */
	public String getCode(){
		return code;
	}

	/**
	 *设置区域名称
	 *@param: name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 *获取区域名称
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
	 *设置是否逻辑删除
	 *@param: logicRemove
	 */
	public void setLogicRemove(int logicRemove){
		this.logicRemove = logicRemove;
	}

	/**
	 *获取是否逻辑删除
	 *@return
	 */
	public int getLogicRemove(){
		return logicRemove;
	}

}