package cn.com.bgy.ifc.entity.vo.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SystemRoleVo {

	/**
	 *系统自增Id
	 */
	private Long id;
	/**
	 *角色类型
	 */
	@NotNull(message="角色分类不能为空！")
	private Integer type;
	/**
	 *角色名称
	 */
	@NotBlank(message="角色名称不能为空！")
	@Size(max=50,message="角色名称长度不能超过50字符！")
	private String name;

	/**
	 * 角色标示
	 */
	private String value;
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
	 * 接受前端关键字
	 */
	private String keyWords;
	/**
	 * 接受当前登录用id
	 */
	private Long userId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}


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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}