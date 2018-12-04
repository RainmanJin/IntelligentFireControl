package cn.com.bgy.ifc.entity.po.basic;

public class SystemUserRole {

	/**
	 *系统自增Id
	 */
	private Long id;

	/**
	 *系统角色表主键Id
	 */
	private Long roleId;

	/**
	 *用户表主键Id
	 */
	private Long userId;

	public SystemUserRole(){
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
	 *设置系统角色表主键Id
	 *@param: roleId
	 */
	public void setRoleId(Long roleId){
		this.roleId = roleId;
	}

	/**
	 *获取系统角色表主键Id
	 *@return
	 */
	public Long getRoleId(){
		return roleId;
	}

	/**
	 *设置用户表主键Id
	 *@param: userId
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}

	/**
	 *获取用户表主键Id
	 *@return
	 */
	public Long getUserId(){
		return userId;
	}

}