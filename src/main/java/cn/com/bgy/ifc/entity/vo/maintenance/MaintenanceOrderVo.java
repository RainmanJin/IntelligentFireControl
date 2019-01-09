package cn.com.bgy.ifc.entity.vo.maintenance;

import java.util.Date;
/**
 * 维保工单
 * @author Administrator
 *
 */
public class MaintenanceOrderVo {
	//主键ID
    private Long id;
    //维保计划ID
    private Long planId;
    //维保计划名称
    private String planName;
    //维保设备信息ID
    private Long deviceId;
    //周期性计划ID
    private Long periodicId;
    //维保设备信息名称
    private String deviceName;
    //机构id
    private Long organizationId;
    //机构名称
    private String organizationName;
    //维保人员电话备注信息
    private String staffInfo;
    //备注信息
    private String remark;
    //维保签字信息
    private String sign;
    //维保处理时间
    private Date handleTime;
    //工单状态
    private Integer orderState;
    //创建时间
    private Date createTime;
    //是否逻辑删除
    private Boolean logicRemove;
    //是否是维保周期任务工单0 是    1 不是
    private Boolean cycle;

    public Long getId() {
        return id;
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

    public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
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

    public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
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