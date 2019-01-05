package cn.com.bgy.ifc.entity.vo.maintenance;

import java.util.Date;
/**
 * 2018年12月25日14:34:44
 * lbj
 * 维保计划
 */
public class MaintenancePlanVo {
    private Long id;
    //组织机构ID
    private Long organizationId;
    //组织机构名称
    private String organizationName; 
    //维保策略名称
    private String planName; 
    //所属区域IC
    private Long regionId;
    //所属区域名称
    private String regionName;
    //项目IC
    private Long projectId;
    //项目名称
    private String projectName;
    //范围类型：1半月维保项目、2季度维保项目、3半年维保项目、4年度维保项目
    private Long projectType;
    //保养开始日期
    private Date beginDate;
    //保养结束日期
    private Date endDate;
    //维保公司Id
    private Long companyId;
    //维保公司名称
    private String companyName;
   //查询关键字
    private String keyword;
    //创建时间
    private Date createTime;
    //开始日期
    private Date beginTime;
    //结束日期
    private Date endTime;
    //是否逻辑删除
    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrganizationName() {
		return organizationName;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectType() {
        return projectType;
    }

    public void setProjectType(Long projectType) {
        this.projectType = projectType;
    }

    public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
}