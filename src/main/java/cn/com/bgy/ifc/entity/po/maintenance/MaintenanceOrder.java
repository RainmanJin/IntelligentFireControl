package cn.com.bgy.ifc.entity.po.maintenance;

import java.util.Date;
/**
 * 维保工单
 * @author Administrator
 *
 */
public class MaintenanceOrder {
	//主键ID
    private Long id;
    //维保计划ID
    private Long planId;
    //周期性计划ID
    private Long periodicId;
    //维保计划名称
    private String planName;
    //维保设备信息ID
    private Long deviceId;
    //维保设备信息名称
    private String deviceName;
    //所属区域IC
    private Long regionId;
    //所属区域名称
    private String regionName;
    //项目IC
    private Long projectId;
    //项目名称
    private String projectName;
    //项目名称
    private String projectType;
    //机构id
    private Long organizationId;
    //机构名称
    private String organizationName;
    //维保人员电话备注信息
    private String staffInfo;
    //备注信息
    private String remark;
    //备注信息
    private String keyword;
    //地址
    private String address;
    //维保签字信息
    private String sign;
    //维保处理时间
    private Date handleTime;
    //计划开始日期
    private Date beginTime;
    //计划日期
    private Date planDate;
    //计划结束时间
    private Date endTime;
    //工单状态
    private Integer orderState;
    //创建时间
    private Date createTime;
    //是否逻辑删除
    private Boolean logicRemove;
    //是否是维保周期任务工单1 是    0 不是
    private Boolean cycle;

    public Long getId() {
        return id;
    }

    public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Date getBeginTime() {
		return beginTime;
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

	public String getPlanName() {
		return planName;
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

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}


	public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getStaffInfo() {
        return staffInfo;
    }

    public void setStaffInfo(String staffInfo) {
        this.staffInfo = staffInfo;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
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

    public Boolean getCycle() {
        return cycle;
    }

    public void setCycle(Boolean cycle) {
        this.cycle = cycle;
    }
}