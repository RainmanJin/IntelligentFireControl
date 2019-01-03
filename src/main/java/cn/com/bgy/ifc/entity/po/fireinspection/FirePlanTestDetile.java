package cn.com.bgy.ifc.entity.po.fireinspection;

public class FirePlanTestDetile {
    private Long id;

    private Long firePlanId;

    private Boolean logicRemove;

    private Long fireFacilitiesId;

    private String situation;

    private String result;

    private Long regionId;

    private Long projectId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFirePlanId() {
        return firePlanId;
    }

    public void setFirePlanId(Long firePlanId) {
        this.firePlanId = firePlanId;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public Long getFireFacilitiesId() {
        return fireFacilitiesId;
    }

    public void setFireFacilitiesId(Long fireFacilitiesId) {
        this.fireFacilitiesId = fireFacilitiesId;
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
}