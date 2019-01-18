package cn.com.bgy.ifc.entity.po.fireinspection;

import java.util.Date;

public class FireInspection {
    private Long id;
    /**
     * 区域表Id
     */
    private Long regionId;
    /**
     *
     */
    private String regionName;
    /**
     * 项目表Id
     */
    private Long projectId;
    /**
     *
     */
    private String projectName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 消防巡检名称（区域+项目+防火检查记录表（月/重大节日））
     */
    private String name;
    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;
    /**
     * 检查人意见
     */
    private String examinerOpinion;
    /**
     * 检查人
     */
    private String examiner;
    /**
     * 检查人签字日期
     */
    private Date examinerDate;
    /**
     * 被检查部门负责人意见
     */
    private String managerOpinion;
    /**
     * 被检查部门负责人签字日期
     */
    private Date managerDate;
    /**
     * 被检查部门负责人
     */
    private String manager;
    /**
     * 消防安全管理人意见
     */
    private String fireManagerOpinion;
    /**
     * 消防安全管理人签字日期
     */
    private Date fireManagerDate;
    /**
     * 消防安全管理人
     */
    private String fireManager;
    /**
     * 项目消防安全责任人意见
     */
    private String projectManagerOpinion;
    /**
     * 项目消防安全责任人签字日期
     */
    private Date projectManagerDate;
    /**
     * 项目消防安全责任人
     */
    private String projectManager;
    /**
     * 被检查单位 (部位）
     */
    private String inspectedUnits;
    /**
     * 项目消防安全责任人签字日期
     */
    private Date inspectionDay;
    /**
     * 完成时间
     */
    private Date finishTime;
    /**
     * @description:
     * 耗时时间
     */
    private String consumeTime;
    /**
     *查询关键字
     */
    private String keyWords;
    /**
     * @description:检查内容
     */
    private String fireContents;
    /**
     * @description:检查位置
     */
    private String situation;
    /**
     * @description:检查结果
     */
    private String result;
    /**
     * 检查类型(1设施故障检测,2每日防火巡查记,3月/重大节日)
     */
    private int inspectionType;
    /**
     * 工单状态：1草稿、2处理中、3已完成
     */
    private int status;

    public Long getId() {
        return id;
    }

    public String getFireContents() {
		return fireContents;
	}

	public void setFireContents(String fireContents) {
		this.fireContents = fireContents;
	}

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public Date getFinishTime() {
		return finishTime;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getConsumeTime() {
		return consumeTime;
	}

	public void setConsumeTime(String consumeTime) {
		this.consumeTime = consumeTime;
	}

	public int getInspectionType() {
		return inspectionType;
	}

	public void setInspectionType(int inspectionType) {
		this.inspectionType = inspectionType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

    public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Date getInspectionDay() {
		return inspectionDay;
	}

	public void setInspectionDay(Date inspectionDay) {
		this.inspectionDay = inspectionDay;
	}

	public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getExaminerOpinion() {
        return examinerOpinion;
    }

    public void setExaminerOpinion(String examinerOpinion) {
        this.examinerOpinion = examinerOpinion;
    }

    public String getExaminer() {
        return examiner;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public Date getExaminerDate() {
        return examinerDate;
    }

    public void setExaminerDate(Date examinerDate) {
        this.examinerDate = examinerDate;
    }

    public String getManagerOpinion() {
        return managerOpinion;
    }

    public void setManagerOpinion(String managerOpinion) {
        this.managerOpinion = managerOpinion;
    }

    public Date getManagerDate() {
        return managerDate;
    }

    public void setManagerDate(Date managerDate) {
        this.managerDate = managerDate;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getFireManagerOpinion() {
        return fireManagerOpinion;
    }

    public void setFireManagerOpinion(String fireManagerOpinion) {
        this.fireManagerOpinion = fireManagerOpinion;
    }

    public Date getFireManagerDate() {
        return fireManagerDate;
    }

    public void setFireManagerDate(Date fireManagerDate) {
        this.fireManagerDate = fireManagerDate;
    }

    public String getFireManager() {
        return fireManager;
    }

    public void setFireManager(String fireManager) {
        this.fireManager = fireManager;
    }

    public String getProjectManagerOpinion() {
        return projectManagerOpinion;
    }

    public void setProjectManagerOpinion(String projectManagerOpinion) {
        this.projectManagerOpinion = projectManagerOpinion;
    }

    public Date getProjectManagerDate() {
        return projectManagerDate;
    }

    public void setProjectManagerDate(Date projectManagerDate) {
        this.projectManagerDate = projectManagerDate;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getInspectedUnits() {
        return inspectedUnits;
    }

    public void setInspectedUnits(String inspectedUnits) {
        this.inspectedUnits = inspectedUnits;
    }
}