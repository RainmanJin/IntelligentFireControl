package cn.com.bgy.ifc.entity.po.maintenance;

import java.util.Date;
/**
 * 维保周期性计划
 * 2018年12月27日17:32:06
 * @author lvbingjian
 *
 */
public class MaintenancePeriodic {
	private Long id;
	// 组织机构Id
	private Long organizationId;
	// 组织机构名称
	private String organizationName;
	// 区域ID
	private Long regionId;
	// 区域名称
	private String regionName;
	// 项目ID
	private Long projectId;
	// 项目名称
	private String projectName;
	// 设备ID
	private Long equipmentId;
	// 设备名称
	private String equipmentName;
	//关键字查询
	private String keyword;
	// 维保内容
	private String content;
	// 维保公司ID
	private Long companyId;
	// 维保公司名称
	private String companyName;
	// 维保周期时间 1月2季3半年4年5自定义（天）
	private Integer cycleType;
	// 维保周期自定义天数
	private Integer cycleDay;
	// 维保结束时间
	private Date endTime;
	// 维保开始时间
	private Date startTime;
	// 新增修改时间
	private Date createTime;
	// 维保总次数
	private Integer sum;
	// 是否逻辑删除
	private Boolean logicRemove;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}


	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) {
		this.equipmentId = equipmentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Integer getCycleType() {
		return cycleType;
	}

	public void setCycleType(Integer cycleType) {
		this.cycleType = cycleType;
	}

	public Integer getCycleDay() {
		return cycleDay;
	}

	public void setCycleDay(Integer cycleDay) {
		this.cycleDay = cycleDay;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Boolean getLogicRemove() {
		return logicRemove;
	}

	public void setLogicRemove(Boolean logicRemove) {
		this.logicRemove = logicRemove;
	}
}