package cn.com.bgy.ifc.entity.vo.basic;

public class SystemOperationLogVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	/**
	 *操作内容
	 */
	private String operatorContent;

	/**
	 *描述
	 */
	private String operatorDescribe;

	/**
	 *操作员Id
	 */
	private Long userId;

	/**
	 *操作员姓名
	 */
	private String userName;

	/**
	 *日志类型
	 */
	private int logType;

	/**
	 *Ip地址
	 */
	private String ip;

	/**
	 *创建、修改时间
	 */
	private java.util.Date createTime;

	/**
	 *是否逻辑删除
	 */
	private int logicRemove;

	public SystemOperationLogVo(){
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
	 *设置操作内容
	 *@param: operatorContent
	 */
	public void setOperatorContent(String operatorContent){
		this.operatorContent = operatorContent;
	}

	/**
	 *获取操作内容
	 *@return
	 */
	public String getOperatorContent(){
		return operatorContent;
	}

	/**
	 *设置描述
	 *@param: operatorDescribe
	 */
	public void setOperatorDescribe(String operatorDescribe){
		this.operatorDescribe = operatorDescribe;
	}

	/**
	 *获取描述
	 *@return
	 */
	public String getOperatorDescribe(){
		return operatorDescribe;
	}

	/**
	 *设置操作员Id
	 *@param: userId
	 */
	public void setUserId(Long userId){
		this.userId = userId;
	}

	/**
	 *获取操作员Id
	 *@return
	 */
	public Long getUserId(){
		return userId;
	}

	/**
	 *设置操作员姓名
	 *@param: userName
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}

	/**
	 *获取操作员姓名
	 *@return
	 */
	public String getUserName(){
		return userName;
	}

	/**
	 *设置日志类型
	 *@param: logType
	 */
	public void setLogType(int logType){
		this.logType = logType;
	}

	/**
	 *获取日志类型
	 *@return
	 */
	public int getLogType(){
		return logType;
	}

	/**
	 *设置Ip地址
	 *@param: ip
	 */
	public void setIp(String ip){
		this.ip = ip;
	}

	/**
	 *获取Ip地址
	 *@return
	 */
	public String getIp(){
		return ip;
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
	public void setLogicRemove(Integer logicRemove){
		this.logicRemove = logicRemove;
	}

	/**
	 *获取是否逻辑删除
	 *@return
	 */
	public Integer getLogicRemove(){
		return logicRemove;
	}

}