package cn.com.bgy.ifc.entity.po.fireinspection;

import cn.com.bgy.ifc.entity.po.project.RegionInfo;

import java.util.Date;

public class FireTaskDrill {
    /**
     * 
     */
    private Long id;

    /**
     * 消防演练任务名称
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
     * 地  点
     */
    private String place;

    /**
     * 指挥人
     */
    private String command;

    /**
     * 参加部门
     */
    private String department;

    /**
     * 出动人数
     */
    private Integer dispatchedPerson;

    /**
     * 出动车数
     */
    private Integer vehiclesDispatched;

    /**
     * 物业名称
     */
    private String propertyName;

    /**
     * 所属区域ID
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
     * 消防演练内容
     */
    private String content;

    /**
     * 消防演练结果
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
     * 消防演练任务名称
     * @return name 消防演练任务名称
     */
    public String getName() {
        return name;
    }

    /**
     * 消防演练任务名称
     * @param name 消防演练任务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 计划周期
     * @return plan_cycle 计划周期
     */
    public Integer getPlanCycle() {
        return planCycle;
    }

    /**
     * 计划周期
     * @param planCycle 计划周期
     */
    public void setPlanCycle(Integer planCycle) {
        this.planCycle = planCycle;
    }

    /**
     * 完成节点 1-进行中 0-已完结
     * @return complete 完成节点 1-进行中 0-已完结
     */
    public Integer getComplete() {
        return complete;
    }

    /**
     * 完成节点 1-进行中 0-已完结
     * @param complete 完成节点 1-进行中 0-已完结
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
     * 地  点
     * @return place 地  点
     */
    public String getPlace() {
        return place;
    }

    /**
     * 地  点
     * @param place 地  点
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 指挥人
     * @return command 指挥人
     */
    public String getCommand() {
        return command;
    }

    /**
     * 指挥人
     * @param command 指挥人
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * 参加部门
     * @return department 参加部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 参加部门
     * @param department 参加部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 出动人数
     * @return dispatched_person 出动人数
     */
    public Integer getDispatchedPerson() {
        return dispatchedPerson;
    }

    /**
     * 出动人数
     * @param dispatchedPerson 出动人数
     */
    public void setDispatchedPerson(Integer dispatchedPerson) {
        this.dispatchedPerson = dispatchedPerson;
    }

    /**
     * 出动车数
     * @return vehicles_dispatched 出动车数
     */
    public Integer getVehiclesDispatched() {
        return vehiclesDispatched;
    }

    /**
     * 出动车数
     * @param vehiclesDispatched 出动车数
     */
    public void setVehiclesDispatched(Integer vehiclesDispatched) {
        this.vehiclesDispatched = vehiclesDispatched;
    }

    /**
     * 物业名称
     * @return property_name 物业名称
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * 物业名称
     * @param propertyName 物业名称
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /**
     * 所属区域ID
     * @return region_id 所属区域ID
     */
    public Long getRegionId() {
        return regionId;
    }

    /**
     * 所属区域ID
     * @param regionId 所属区域ID
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