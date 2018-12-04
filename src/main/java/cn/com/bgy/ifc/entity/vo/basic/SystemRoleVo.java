package cn.com.bgy.ifc.entity.vo.basic;

public class SystemRoleVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	/**
	 *角色名称
	 */
	private String name;

	/**
	 *机构表Id，用于区分平台
	 */
	private Long organizationId;

	/**
	 *是否逻辑删除
	 */
	private int logicRemove;

	public SystemRoleVo(){
}
	/**
	 *设置系统自增Id
	 *@param: id
	 */
	public void setId(Long id){
		this.id = id;
	}

	/**
	 *获取系统自增Id
	 *@return
	 */
	public Long getId(){
		return id;
	}

	/**
	 *设置角色名称
	 *@param: name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 *获取角色名称
	 *@return
	 */
	public String getName(){
		return name;
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