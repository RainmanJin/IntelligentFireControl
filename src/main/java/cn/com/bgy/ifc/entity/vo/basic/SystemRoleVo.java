package cn.com.bgy.ifc.entity.vo.basic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SystemRoleVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	/**
	 *角色名称
	 */
	@NotBlank(message="角色名称不能为空")
	@Size(max=40,message="角色名称长度不正确")
	private String name;

	/**
	 *机构表Id，用于区分平台
	 */
	@NotNull(message="机构ID不能为空")
	private Long organizationId;

	/**
	 *是否逻辑删除
	 */
	private Boolean logicRemove;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Boolean getLogicRemove() {
		return logicRemove;
	}

}