package cn.com.bgy.ifc.entity.vo.basic;

public class AccountVo {

	/**
	 *使用集成平台接口中的Id
	 */
	private Long id;

	/**
	 *机构表Id，用于区分平台
	 */
	private Long organizationId;

	/**
	 *部门表Id，未设置为0
	 */
	private Long departmentId;

	/**
	 *账号(手机号码)
	 */
	private String telephone;

	/**
	 *工号
	 */
	private String jobNumber;

	/**
	 *用户名
	 */
	private String userName;

	/**
	 *登录密码(默认为手机号的后六位)
	 */
	private String password;

	/**
	 *密钥_盐
	 */
	private String passwordSalt;

	/**
	 *身份证号
	 */
	private String identityNumber;

	/**
	 *性别(0-男;1-女)
	 */
	private int sex;

	/**
	 *备注
	 */
	private String remark;

	/**
	 *注册时间yyyy-mm-dd hh:mm:ss
	 */
	private java.util.Date registTime;

	/**
	 *可用标志(0-禁用,1-启用,2-锁定,3-删除)
	 */
	private int isDisable;

	/**
	 *当前登录IP
	 */
	private String currentIp;

	/**
	 *当前登录时间
	 */
	private java.util.Date currentTime;

	/**
	 *上次登录IP
	 */
	private String lastIp;

	/**
	 *上次登录时间
	 */
	private java.util.Date lastTime;

	/**
	 *用户类型(0一般用户,1机构管理员,2系统管理员,3技术管理员)
	 */
	private int userType;

	public AccountVo(){
}
	/**
	 *设置使用集成平台接口中的Id
	 *@param: id
	 */
	public void setId(long id){
		this.id = id;
	}

	/**
	 *获取使用集成平台接口中的Id
	 *@return
	 */
	public long getId(){
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
	 *设置部门表Id，未设置为0
	 *@param: departmentId
	 */
	public void setDepartmentId(Long departmentId){
		this.departmentId = departmentId;
	}

	/**
	 *获取部门表Id，未设置为0
	 *@return
	 */
	public Long getDepartmentId(){
		return departmentId;
	}

	/**
	 *设置账号(手机号码)
	 *@param: telephone
	 */
	public void setTelephone(String telephone){
		this.telephone = telephone;
	}

	/**
	 *获取账号(手机号码)
	 *@return
	 */
	public String getTelephone(){
		return telephone;
	}

	/**
	 *设置工号
	 *@param: jobNumber
	 */
	public void setJobNumber(String jobNumber){
		this.jobNumber = jobNumber;
	}

	/**
	 *获取工号
	 *@return
	 */
	public String getJobNumber(){
		return jobNumber;
	}

	/**
	 *设置用户名
	 *@param: userName
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}

	/**
	 *获取用户名
	 *@return
	 */
	public String getUserName(){
		return userName;
	}

	/**
	 *设置登录密码(默认为手机号的后六位)
	 *@param: password
	 */
	public void setPassword(String password){
		this.password = password;
	}

	/**
	 *获取登录密码(默认为手机号的后六位)
	 *@return
	 */
	public String getPassword(){
		return password;
	}

	/**
	 *设置密钥_盐
	 *@param: passwordSalt
	 */
	public void setPasswordSalt(String passwordSalt){
		this.passwordSalt = passwordSalt;
	}

	/**
	 *获取密钥_盐
	 *@return
	 */
	public String getPasswordSalt(){
		return passwordSalt;
	}

	/**
	 *设置身份证号
	 *@param: identityNumber
	 */
	public void setIdentityNumber(String identityNumber){
		this.identityNumber = identityNumber;
	}

	/**
	 *获取身份证号
	 *@return
	 */
	public String getIdentityNumber(){
		return identityNumber;
	}

	/**
	 *设置性别(0-男;1-女)
	 *@param: sex
	 */
	public void setSex(int sex){
		this.sex = sex;
	}

	/**
	 *获取性别(0-男;1-女)
	 *@return
	 */
	public int getSex(){
		return sex;
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
	 *设置注册时间yyyy-mm-dd hh:mm:ss
	 *@param: registTime
	 */
	public void setRegistTime(java.util.Date registTime){
		this.registTime = registTime;
	}

	/**
	 *获取注册时间yyyy-mm-dd hh:mm:ss
	 *@return
	 */
	public java.util.Date getRegistTime(){
		return registTime;
	}

	/**
	 *设置可用标志(0-禁用,1-启用,2-锁定,3-删除)
	 *@param: isDisable
	 */
	public void setIsDisable(int isDisable){
		this.isDisable = isDisable;
	}

	/**
	 *获取可用标志(0-禁用,1-启用,2-锁定,3-删除)
	 *@return
	 */
	public int getIsDisable(){
		return isDisable;
	}

	/**
	 *设置当前登录IP
	 *@param: currentIp
	 */
	public void setCurrentIp(String currentIp){
		this.currentIp = currentIp;
	}

	/**
	 *获取当前登录IP
	 *@return
	 */
	public String getCurrentIp(){
		return currentIp;
	}

	/**
	 *设置当前登录时间
	 *@param: currentTime
	 */
	public void setCurrentTime(java.util.Date currentTime){
		this.currentTime = currentTime;
	}

	/**
	 *获取当前登录时间
	 *@return
	 */
	public java.util.Date getCurrentTime(){
		return currentTime;
	}

	/**
	 *设置上次登录IP
	 *@param: lastIp
	 */
	public void setLastIp(String lastIp){
		this.lastIp = lastIp;
	}

	/**
	 *获取上次登录IP
	 *@return
	 */
	public String getLastIp(){
		return lastIp;
	}

	/**
	 *设置上次登录时间
	 *@param: lastTime
	 */
	public void setLastTime(java.util.Date lastTime){
		this.lastTime = lastTime;
	}

	/**
	 *获取上次登录时间
	 *@return
	 */
	public java.util.Date getLastTime(){
		return lastTime;
	}

	/**
	 *设置用户类型(0一般用户,1机构管理员,2系统管理员,3技术管理员)
	 *@param: userType
	 */
	public void setUserType(int userType){
		this.userType = userType;
	}

	/**
	 *获取用户类型(0一般用户,1机构管理员,2系统管理员,3技术管理员)
	 *@return
	 */
	public int getUserType(){
		return userType;
	}

}