package cn.com.bgy.ifc.entity.po.fireinspection;

import java.util.Date;

public class FireInspection {
    private Long id;

    private Long regionId;

    private Long projectId;

    private Date createTime;

    private String name;

    private Boolean logicRemove;

    private String examinerOpinion;

    private String examiner;

    private Date examinerDate;

    private String managerOpinion;

    private Date managerDate;

    private String manager;

    private String fireManagerOpinion;

    private Date fireManagerDate;

    private String fireManager;

    private String projectManagerOpinion;

    private Date projectManagerDate;

    private String projectManager;

    private String inspectedUnits;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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