package cn.com.bgy.ifc.entity.vo.basic;

public class SystemPowerVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	/**
	 *权限名称
	 */
	private String name;

	/**
	 *权限展示名称
	 */
	private String displayName;

	/**
	 *备注
	 */
	private String remark;

	/**
	 *是否逻辑删除
	 */
	private int logicRemove;

	public SystemPowerVo(){
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
	 *设置权限名称
	 *@param: name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 *获取权限名称
	 *@return
	 */
	public String getName(){
		return name;
	}

	/**
	 *设置权限展示名称
	 *@param: displayName
	 */
	public void setDisplayName(String displayName){
		this.displayName = displayName;
	}

	/**
	 *获取权限展示名称
	 *@return
	 */
	public String getDisplayName(){
		return displayName;
	}

	/**
	 *设置备注
	 *@param: remark
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}

	/**
	 *获取备注
	 *@return
	 */
	public String getRemark(){
		return remark;
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