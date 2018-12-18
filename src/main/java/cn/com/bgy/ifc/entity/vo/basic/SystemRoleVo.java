package cn.com.bgy.ifc.entity.vo.basic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SystemRoleVo {

	/**
	 *系统自增Id
	 */
	private Long id;
	/**
	 *角色类型
	 */
	private Integer type;
	/**
	 *角色名称
	 */
	@NotBlank(message="角色名称不能为空")
	@Size(max=40,message="角色名称长度不正确")
	private String name;
	/*
	 * 状态：0 启用 	1 禁用
	 */
	private Integer state;
	/**
	 *机构表Id，用于区分平台
	 */
	private Long organizationId;

	/**
	 *是否逻辑删除
	 */
	private Boolean logicRemove;
	
	/**
	 * @Author huxin
	 * @Description 查询关键字
	 * @Date 2018/12/18 10:55
	 */
	private String keyword;


	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType( Integer type ) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState( Integer state ) {
		this.state = state;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId( Long organizationId ) {
		this.organizationId = organizationId;
	}

	public Boolean getLogicRemove() {
		return logicRemove;
	}

	public void setLogicRemove( Boolean logicRemove ) {
		this.logicRemove = logicRemove;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword( String keyword ) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SystemRoleVo{" + "id=" + id + ", type=" + type + ", name='" + name + '\'' + ", state=" + state + ", organizationId=" + organizationId + ", logicRemove=" + logicRemove + ", keyword='" + keyword + '\'' + '}';
	}
}