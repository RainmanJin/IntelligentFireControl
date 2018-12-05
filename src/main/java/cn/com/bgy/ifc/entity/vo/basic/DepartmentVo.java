package cn.com.bgy.ifc.entity.vo.basic;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class DepartmentVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	private Long parentId;

	@NotBlank(message="部门名称不能为空")
	@Size(max=50,message="部门名称长度不正确")
	private String name;

	private Integer state;

	/**
	 *机构表Id，用于区分平台
	 */
	@NotNull(message="机构ID不能为空")
	private Long organizationId;

	private Date createTime;

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

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getLogicRemove() {
		return logicRemove;
	}

	public void setLogicRemove(Boolean logicRemove) {
		this.logicRemove = logicRemove;
	}

	@Override
	public String toString() {
		return "Department{" +
				"id=" + id +
				", parentId=" + parentId +
				", name='" + name + '\'' +
				", state=" + state +
				", organizationId=" + organizationId +
				", createTime=" + createTime +
				", logicRemove=" + logicRemove +
				'}';
	}
}