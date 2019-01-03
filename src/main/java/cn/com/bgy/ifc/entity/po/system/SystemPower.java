package cn.com.bgy.ifc.entity.po.system;

public class SystemPower {
    private Long id;

    private String name;

    private String displayName;

    private String remark;

    private Boolean logicRemove;

    private Long moduleId;

    private SystemMenu systemMenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public SystemMenu getSystemMenu() {
        return systemMenu;
    }

    public void setSystemMenu(SystemMenu systemMenu) {
        this.systemMenu = systemMenu;
    }
}