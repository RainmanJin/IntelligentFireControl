package cn.com.bgy.ifc.entity.po.fireinspection;

public class FireInspectionDetail {
    /**
     * 系统自增ID
     */
    private Long id;

    /**
     * 消防巡检主表单Id
     */
    private Long fireInspeId;

    /**
     * 检查内容码表ID
     */
    private Long fireContentsId;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    /**
     * 检查情况
     */
    private String situation;

    /**
     * 处置结果
     */
    private String result;

    /**
     * 系统自增ID
     * @return id 系统自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 系统自增ID
     * @param id 系统自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 消防巡检主表单Id
     * @return fire_inspe_id 消防巡检主表单Id
     */
    public Long getFireInspeId() {
        return fireInspeId;
    }

    /**
     * 消防巡检主表单Id
     * @param fireInspeId 消防巡检主表单Id
     */
    public void setFireInspeId(Long fireInspeId) {
        this.fireInspeId = fireInspeId;
    }

    /**
     * 检查内容码表ID
     * @return fire_contents_id 检查内容码表ID
     */
    public Long getFireContentsId() {
        return fireContentsId;
    }

    /**
     * 检查内容码表ID
     * @param fireContentsId 检查内容码表ID
     */
    public void setFireContentsId(Long fireContentsId) {
        this.fireContentsId = fireContentsId;
    }

    /**
     * 是否逻辑删除
     * @return logic_remove 是否逻辑删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除
     * @param logicRemove 是否逻辑删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    /**
     * 检查情况
     * @return situation 检查情况
     */
    public String getSituation() {
        return situation;
    }

    /**
     * 检查情况
     * @param situation 检查情况
     */
    public void setSituation(String situation) {
        this.situation = situation;
    }

    /**
     * 处置结果
     * @return result 处置结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 处置结果
     * @param result 处置结果
     */
    public void setResult(String result) {
        this.result = result;
    }
}