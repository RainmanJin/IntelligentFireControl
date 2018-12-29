package cn.com.bgy.ifc.entity.po.fireinspection;

public class FireInspectionDetail {
    private Long id;

    private Long fireInspeId;

    private Long fireContentsId;

    private Boolean logicRemove;

    private String situation;

    private String result;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFireInspeId() {
        return fireInspeId;
    }

    public void setFireInspeId(Long fireInspeId) {
        this.fireInspeId = fireInspeId;
    }

    public Long getFireContentsId() {
        return fireContentsId;
    }

    public void setFireContentsId(Long fireContentsId) {
        this.fireContentsId = fireContentsId;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
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
}