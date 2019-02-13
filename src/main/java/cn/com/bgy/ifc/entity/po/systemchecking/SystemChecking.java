package cn.com.bgy.ifc.entity.po.systemchecking;

import cn.com.bgy.ifc.entity.po.system.Account;

import java.util.Date;

public class SystemChecking {
    /**
     * 系统ID
     */
    private Long id;

    /**
     * 所属项目
     */
    private Long projectId;

    /**
     * 系统巡检类型 1:巡检 2：体检
     */
    private Integer type;

    /**
     * 巡检人员ID
     */
    private Long inspectors;

    /**
     * 巡检时间
     */
    private Date inspectionTime;

    /**
     * 检测类型 1：一键巡检 2：自动巡检
     */
    private Integer testType;

    /**
     * 是否存在Excel文件 true:存在 false:不存在
     */
    private Boolean hasFile;

    /**
     * 是否删除 
     */
    private Boolean logicRemove;

    /**
     * 创建修改时间
     */
    private Date createTime;

    /**
     * 成员
     */
    private Account account;

    /**
     * 系统ID
     * @return id 系统ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 系统ID
     * @param id 系统ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 所属项目
     * @return project_id 所属项目
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 所属项目
     * @param projectId 所属项目
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 系统巡检类型 1:巡检 2：体检
     * @return type 系统巡检类型 1:巡检 2：体检
     */
    public Integer getType() {
        return type;
    }

    /**
     * 系统巡检类型 1:巡检 2：体检
     * @param type 系统巡检类型 1:巡检 2：体检
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 巡检人员ID
     * @return inspectors 巡检人员ID
     */
    public Long getInspectors() {
        return inspectors;
    }

    /**
     * 巡检人员ID
     * @param inspectors 巡检人员ID
     */
    public void setInspectors(Long inspectors) {
        this.inspectors = inspectors;
    }

    /**
     * 巡检时间
     * @return inspection_time 巡检时间
     */
    public Date getInspectionTime() {
        return inspectionTime;
    }

    /**
     * 巡检时间
     * @param inspectionTime 巡检时间
     */
    public void setInspectionTime(Date inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    /**
     * 检测类型 1：一键巡检 2：自动巡检
     * @return test_type 检测类型 1：一键巡检 2：自动巡检
     */
    public Integer getTestType() {
        return testType;
    }

    /**
     * 检测类型 1：一键巡检 2：自动巡检
     * @param testType 检测类型 1：一键巡检 2：自动巡检
     */
    public void setTestType(Integer testType) {
        this.testType = testType;
    }

    /**
     * 是否存在Excel文件 true:存在 false:不存在
     * @return has_file 是否存在Excel文件 true:存在 false:不存在
     */
    public Boolean getHasFile() {
        return hasFile;
    }

    /**
     * 是否存在Excel文件 true:存在 false:不存在
     * @param hasFile 是否存在Excel文件 true:存在 false:不存在
     */
    public void setHasFile(Boolean hasFile) {
        this.hasFile = hasFile;
    }

    /**
     * 是否删除 
     * @return logic_remove 是否删除 
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否删除 
     * @param logicRemove 是否删除 
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    /**
     * 创建修改时间
     * @return create_time 创建修改时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建修改时间
     * @param createTime 创建修改时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}