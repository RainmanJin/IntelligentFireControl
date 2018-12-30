package cn.com.bgy.ifc.entity.vo.fireinspection;

import java.util.Date;

public class FireHiddenDangerVo {
    private Long id;

    private String inspectedUnits;

    private String examiner;

    private Date inspectionDay;

    private String recOpinion;

    private Boolean logicRemove;

    private String managerOpinion;

    private Date managerDate;

    private String fireManagerOpinion;

    private Date fireManagerDate;

    private String manager;

    private String fireManager;

    private String result;

    private String proFireManager;

    private String projectManager;

    public Long getId() {
        return id;
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

    public String getExaminer() {
        return examiner;
    }

    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    public Date getInspectionDay() {
        return inspectionDay;
    }

    public void setInspectionDay(Date inspectionDay) {
        this.inspectionDay = inspectionDay;
    }

    public String getRecOpinion() {
        return recOpinion;
    }

    public void setRecOpinion(String recOpinion) {
        this.recOpinion = recOpinion;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getProFireManager() {
        return proFireManager;
    }

    public void setProFireManager(String proFireManager) {
        this.proFireManager = proFireManager;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
}