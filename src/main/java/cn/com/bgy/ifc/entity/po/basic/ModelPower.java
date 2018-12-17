package cn.com.bgy.ifc.entity.po.basic;

/**
 * 系统权限
 */
public class ModelPower extends PageUtil{
    /**
     *系统权限
     */
    private Long id;
    /**
     *权限名称
     */
    private String powerName;
    /**
     *权限展示名称
     */
    private String displayName;
    /**
     *备注
     */
    private String remark;
    /**
     *是否逻辑删除
     */
    private Boolean logicRemove;
    /**
     *模块名称
     */
    private String modelName;
    /**
     *关键字
     */
    private String keyWords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
