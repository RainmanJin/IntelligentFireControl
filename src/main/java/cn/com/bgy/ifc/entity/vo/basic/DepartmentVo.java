package cn.com.bgy.ifc.entity.vo.basic;

import java.util.Date;

public class DepartmentVo {
	private Long id;

	private Long parentId;

	private String name;

	private Integer state;

	private Long organizationId;

	private Date createTime;

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