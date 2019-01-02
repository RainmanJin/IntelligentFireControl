package cn.com.bgy.ifc.entity.po.fireinspection;

import java.util.Date;

public class FireInspectionDay {
    private Long id;

    private String inspectedUnits;

    private Date inspectionDay;

    private String situation;

    private String resoult;

    private String examiner;

    private String manager;

    private String fireManager;

    private String projectManager;
    
    private String fireContents;

    private Date createTime;

    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public String getFireContents() {
		return fireContents;
	}

	public void setFireContents(String fireContents) {
		this.fireContents = fireContents;
	}

	public void setId(Long id) {
        this.id = id;
    }

    public String getInspectedUnits() {
        return inspectedUnits;
    }

    public void setInspectedUnits(String inspectedUnits) {
        this.inspectedUnits = inspectedUnits;
    }

    public Date getInspectionDay() {
        return inspectionDay;
    }

    public void setInspectionDay(Date inspectionDay) {
        this.inspectionDay = inspectionDay;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getResoult() {
        return resoult;
    }

    public void setResoult(String resoult) {
        this.resoult = resoult;
    }

    public String getExaminer() {
        return examiner;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getFireManager() {
        return fireManager;
    }

    public void setFireManager(String fireManager) {
        this.fireManager = fireManager;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
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