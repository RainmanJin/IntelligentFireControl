package cn.com.bgy.ifc.entity.po.fireinspection;

import cn.com.bgy.ifc.entity.po.project.RegionInfo;

import java.util.Date;

public class FireTaskTrain {
    private Long id;

    /**
     * 消防培训任务名称
     */
    private String name;

    /**
     * 任务周期
     */
    private Integer planCycle;

    /**
     * 工作状态 未处理-1、处理中-2、已完成-3
     */
    private Integer complete;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 人数
     */
    private Integer number;

    /**
     * 培训对象
     */
    private String trainingObject;

    /**
     * 培训部门
     */
    private String department;

    /**
     * 合格率
     */
    private Integer passRate;

    /**
     * 区域ID
     */
    private Long regionId;

    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    /**
     * 消防培训内容
     */
    private String content;

    /**
     * 消防培训结果
     */
    private String trainResults;

    /**
     * 所属区域
     */
    private RegionInfo regionInfo;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 消防培训任务名称
     * @return name 消防培训任务名称
     */
    public String getName() {
        return name;
    }

    /**
     * 消防培训任务名称
     * @param name 消防培训任务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 任务周期
     * @return plan_cycle 任务周期
     */
    public Integer getPlanCycle() {
        return planCycle;
    }

    /**
     * 任务周期
     * @param planCycle 任务周期
     */
    public void setPlanCycle(Integer planCycle) {
        this.planCycle = planCycle;
    }

    /**
     * 工作状态 未处理-1、处理中-2、已完成-3
     * @return complete 工作状态 未处理-1、处理中-2、已完成-3
     */
    public Integer getComplete() {
        return complete;
    }

    /**
     * 工作状态 未处理-1、处理中-2、已完成-3
     * @param complete 工作状态 未处理-1、处理中-2、已完成-3
     */
    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 人数
     * @return number 人数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 人数
     * @param number 人数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * 培训对象
     * @return training_object 培训对象
     */
    public String getTrainingObject() {
        return trainingObject;
    }

    /**
     * 培训对象
     * @param trainingObject 培训对象
     */
    public void setTrainingObject(String trainingObject) {
        this.trainingObject = trainingObject;
    }

    /**
     * 培训部门
     * @return department 培训部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 培训部门
     * @param department 培训部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 合格率
     * @return pass_rate 合格率
     */
    public Integer getPassRate() {
        return passRate;
    }

    /**
     * 合格率
     * @param passRate 合格率
     */
    public void setPassRate(Integer passRate) {
        this.passRate = passRate;
    }

    /**
     * 区域ID
     * @return region_id 区域ID
     */
    public Long getRegionId() {
        return regionId;
    }

    /**
     * 区域ID
     * @param regionId 区域ID
     */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    /**
     * 创建、修改时间
     * @return create_time 创建、修改时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建、修改时间
     * @param createTime 创建、修改时间
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrainResults() {
        return trainResults;
    }

    public void setTrainResults(String trainResults) {
        this.trainResults = trainResults;
    }

    public RegionInfo getRegionInfo() {
        return regionInfo;
    }

    public void setRegionInfo(RegionInfo regionInfo) {
        this.regionInfo = regionInfo;
    }
}