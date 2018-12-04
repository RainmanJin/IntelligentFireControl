package cn.com.bgy.ifc.entity.vo.basic;

public class SystemOrganizationVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	/**
	 *机构名称
	 */
	private String name;

	/**
	 *状态，0表示禁用；1表示启用
	 */
	private int state;

	/**
	 *机构管理员，用户表Id
	 */
	private Long userId;

	/**
	 *创建、修改时间
	 */
	private java.util.Date createTime;

	/**
	 *是否逻辑删除
	 */
	private int logicRemove;

	public SystemOrganizationVo(){
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
	 *设置机构名称
	 *@param: name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 *获取机构名称
	 *@return
	 */
	public String getName(){
		return name;
	}

	/**
	 *设置状态，0表示禁用；1表示启用
	 *@param: state
	 */
	public void setState(int state){
		this.state = state;
	}

	/**
	 *获取状态，0表示禁用；1表示启用
	 *@return
	 */
	public int getState(){
		return state;
	}

	/**
	 *设置机构管理员，用户表Id
	 *@param: userId
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}

	/**
	 *获取机构管理员，用户表Id
	 *@return
	 */
	public Long getUserId(){
		return userId;
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