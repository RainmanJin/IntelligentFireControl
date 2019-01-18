package cn.com.bgy.ifc.entity.po.fireinspection;

import java.util.Date;

public class FireInspectionDay {
    /**
     * 系统自增长ID
     */
    private Long id;

    /**
     * 被检查单位
     */
    private String inspectedUnits;

    /**
     * 检查日期
     */
    private Date inspectionDay;

    /**
     * 检查情况
     */
    private String situation;

    /**
     * 处置结果
     */
    private String result;

    /**
     * 检查人
     */
    private String examiner;

    /**
     * 被检查部位、场所负责人
     */
    private String manager;

    /**
     * 消防安全管理人
     */
    private String fireManager;

    /**
     * 项目消防安全责任人
     */
    private String projectManager;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    /**
     * 检查内容
     */
    private String fireContents;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 耗时时间
     */
    private String consumeTime;

    /**
     * 检查类型(1设施故障检测,2每日防火巡查记,3月/重大节日)
     */
    private Integer inspectionType;

    /**
     * 工单状态：1草稿、2处理中、3已完成
     */
    private Integer status;

    /**
     * 系统自增长ID
     * @return id 系统自增长ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 系统自增长ID
     * @param id 系统自增长ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 被检查单位
     * @return inspected_units 被检查单位
     */
    public String getInspectedUnits() {
        return inspectedUnits;
    }

    /**
     * 被检查单位
     * @param inspectedUnits 被检查单位
     */
    public void setInspectedUnits(String inspectedUnits) {
        this.inspectedUnits = inspectedUnits;
    }

    /**
     * 检查日期
     * @return inspection_day 检查日期
     */
    public Date getInspectionDay() {
        return inspectionDay;
    }

    /**
     * 检查日期
     * @param inspectionDay 检查日期
     */
    public void setInspectionDay(Date inspectionDay) {
        this.inspectionDay = inspectionDay;
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
     * @return resoult 处置结果
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

    /**
     * 检查人
     * @return examiner 检查人
     */
    public String getExaminer() {
        return examiner;
    }

    /**
     * 检查人
     * @param examiner 检查人
     */
    public void setExaminer(String examiner) {
        this.examiner = examiner;
    }

    /**
     * 被检查部位、场所负责人
     * @return manager 被检查部位、场所负责人
     */
    public String getManager() {
        return manager;
    }

    /**
     * 被检查部位、场所负责人
     * @param manager 被检查部位、场所负责人
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * 消防安全管理人
     * @return fire_manager 消防安全管理人
     */
    public String getFireManager() {
        return fireManager;
    }

    /**
     * 消防安全管理人
     * @param fireManager 消防安全管理人
     */
    public void setFireManager(String fireManager) {
        this.fireManager = fireManager;
    }

    /**
     * 项目消防安全责任人
     * @return project_manager 项目消防安全责任人
     */
    public String getProjectManager() {
        return projectManager;
    }

    /**
     * 项目消防安全责任人
     * @param projectManager 项目消防安全责任人
     */
    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * 检查内容
     * @return fire_contents 检查内容
     */
    public String getFireContents() {
        return fireContents;
    }

    /**
     * 检查内容
     * @param fireContents 检查内容
     */
    public void setFireContents(String fireContents) {
        this.fireContents = fireContents;
    }

    /**
     * 完成时间
     * @return finish_time 完成时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 完成时间
     * @param finishTime 完成时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 耗时时间
     * @return consume_time 耗时时间
     */
    public String getConsumeTime() {
        return consumeTime;
    }

    /**
     * 耗时时间
     * @param consumeTime 耗时时间
     */
    public void setConsumeTime(String consumeTime) {
        this.consumeTime = consumeTime;
    }

    /**
     * 检查类型(1设施故障检测,2每日防火巡查记,3月/重大节日)
     * @return inspection_type 检查类型(1设施故障检测,2每日防火巡查记,3月/重大节日)
     */
    public Integer getInspectionType() {
        return inspectionType;
    }

    /**
     * 检查类型(1设施故障检测,2每日防火巡查记,3月/重大节日)
     * @param inspectionType 检查类型(1设施故障检测,2每日防火巡查记,3月/重大节日)
     */
    public void setInspectionType(Integer inspectionType) {
        this.inspectionType = inspectionType;
    }

    /**
     * 工单状态：1草稿、2处理中、3已完成
     * @return status 工单状态：1草稿、2处理中、3已完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 工单状态：1草稿、2处理中、3已完成
     * @param status 工单状态：1草稿、2处理中、3已完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}