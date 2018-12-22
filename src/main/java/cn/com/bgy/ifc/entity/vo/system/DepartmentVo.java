package cn.com.bgy.ifc.entity.vo.system;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentVo {

	/**
	 *系统自增Id
	 */
	private Long id;

	private Long parentId;

	@NotBlank(message="部门名称不能为空")
	@Size(max=50,message="部门名称长度不正确")
	private String name;

	/**
	 * 状态
	 */
	private Integer state;

	/**
	 *机构表Id，用于区分平台
	 */
	private Long organizationId;

	/**
	 * 上级部门
	 */
	private String parentName;

	/**
	 * 关键字
	 */
	private String keyword;

	private Date createTime;

	/**
	 *是否逻辑删除
	 */
	private Boolean logicRemove;


	/**
	 * 接受当前登录用id
	 */
	private Long userId;


	private List<DepartmentVo> children = new ArrayList<>();

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

	public List<DepartmentVo> getChildren() {
		return children;
	}

	public void setChildren(List<DepartmentVo> children) {
		this.children = children;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "DepartmentVo{" +
				"id=" + id +
				", parentId=" + parentId +
				", name='" + name + '\'' +
				", state=" + state +
				", organizationId=" + organizationId +
				", parentName='" + parentName + '\'' +
				", keyword='" + keyword + '\'' +
				", createTime=" + createTime +
				", logicRemove=" + logicRemove +
				", children=" + children +
				'}';
	}
}