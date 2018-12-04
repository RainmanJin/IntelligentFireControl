package cn.com.bgy.ifc.entity.vo.basic;

public class SystemMenuVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	/**
	 *菜单名称
	 */
	private String name;

	/**
	 *菜单图标地址
	 */
	private String imageUrl;

	/**
	 *菜单对应的地址
	 */
	private String navigateUrl;

	/**
	 *备注
	 */
	private String remark;

	/**
	 *顺序编号
	 */
	private int sortIndex;

	/**
	 *父级Id
	 */
	private Long parentId;

	/**
	 *系统权限表Id
	 */
	private Long powerId;

	/**
	 *是否逻辑删除
	 */
	private int logicRemove;

	public SystemMenuVo(){
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
	 *设置菜单名称
	 *@param: name
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 *获取菜单名称
	 *@return
	 */
	public String getName(){
		return name;
	}

	/**
	 *设置菜单图标地址
	 *@param: imageUrl
	 */
	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	/**
	 *获取菜单图标地址
	 *@return
	 */
	public String getImageUrl(){
		return imageUrl;
	}

	/**
	 *设置菜单对应的地址
	 *@param: navigateUrl
	 */
	public void setNavigateUrl(String navigateUrl){
		this.navigateUrl = navigateUrl;
	}

	/**
	 *获取菜单对应的地址
	 *@return
	 */
	public String getNavigateUrl(){
		return navigateUrl;
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
	 *设置顺序编号
	 *@param: sortIndex
	 */
	public void setSortIndex(int sortIndex){
		this.sortIndex = sortIndex;
	}

	/**
	 *获取顺序编号
	 *@return
	 */
	public int getSortIndex(){
		return sortIndex;
	}

	/**
	 *设置父级Id
	 *@param: parentId
	 */
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}

	/**
	 *获取父级Id
	 *@return
	 */
	public Long getParentId(){
		return parentId;
	}

	/**
	 *设置系统权限表Id
	 *@param: power-id
	 */
	public void setPowerId(Long powerId){
		this.powerId = powerId;
	}

	/**
	 *获取系统权限表Id
	 *@return
	 */
	public Long getPowerId(){
		return powerId;
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