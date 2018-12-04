package cn.com.bgy.ifc.entity.vo.basic;

public class SystemRolePowerVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	/**
	 *系统角色表主键Id
	 */
	private Long roleId;

	/**
	 *系统权限表主键Id
	 */
	private Long powerId;

	public SystemRolePowerVo(){
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
	 *设置系统权限表主键Id
	 *@param: powerId
	 */
	public void setPowerId(Long powerId){
		this.powerId = powerId;
	}

	/**
	 *获取系统权限表主键Id
	 *@return
	 */
	public Long getPowerId(){
		return powerId;
	}

}