package cn.com.bgy.ifc.entity.po.firepatrol;

import java.math.BigDecimal;
import java.util.Date;

public class FireRehearse {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 演练开始时间
     */
    private Date rehearseStartTime;

    /**
     * 演练结束时间
     */
    private Date rehearseEndTime;

    /**
     * 地点
     */
    private String location;

    /**
     * 演练内容
     */
    private String content;

    /**
     * 指挥人
     */
    private String commandPeople;

    /**
     * 参与部门
     */
    private String department;

    /**
     * 出动人数
     */
    private Integer peopleNum;

    /**
     * 出动车数
     */
    private Integer carNum;

    /**
     * 演练经费报备
     */
    private BigDecimal rehearseCost;

    /**
     * 演练效果
     */
    private String effect;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 物业名称
     */
    private String propertyName;

    /**
     * 宣传开始时间
     */
    private Date advertiseStartTime;

    /**
     * 宣传结束时间
     */
    private Date advertiseEndTime;

    /**
     * 宣传类型
     */
    private Integer advertiseType;

    /**
     * 宣传范围
     */
    private String advertiseScope;

    /**
     * 宣传经费
     */
    private BigDecimal advertiseCost;

    /**
     * 是否逻辑删除0未删除，1已删除
     */
    private Boolean logicRemove;
    /**
     * @description:
     * @param: 
     * @return: 查询关键字
     * @auther: chenlie
     * @date: 2019/1/17 11:55
     */
    private String keyWords;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 主键id
     * @return id 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 演练开始时间
     * @return rehearse_start_time 演练开始时间
     */
    public Date getRehearseStartTime() {
        return rehearseStartTime;
    }

    /**
     * 演练开始时间
     * @param rehearseStartTime 演练开始时间
     */
    public void setRehearseStartTime(Date rehearseStartTime) {
        this.rehearseStartTime = rehearseStartTime;
    }

    /**
     * 演练结束时间
     * @return rehearse_end_time 演练结束时间
     */
    public Date getRehearseEndTime() {
        return rehearseEndTime;
    }

    /**
     * 演练结束时间
     * @param rehearseEndTime 演练结束时间
     */
    public void setRehearseEndTime(Date rehearseEndTime) {
        this.rehearseEndTime = rehearseEndTime;
    }

    /**
     * 地点
     * @return location 地点
     */
    public String getLocation() {
        return location;
    }

    /**
     * 地点
     * @param location 地点
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 演练内容
     * @return content 演练内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 演练内容
     * @param content 演练内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 指挥人
     * @return command_people 指挥人
     */
    public String getCommandPeople() {
        return commandPeople;
    }

    /**
     * 指挥人
     * @param commandPeople 指挥人
     */
    public void setCommandPeople(String commandPeople) {
        this.commandPeople = commandPeople;
    }

    /**
     * 参与部门
     * @return department 参与部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 参与部门
     * @param department 参与部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 出动人数
     * @return people_num 出动人数
     */
    public Integer getPeopleNum() {
        return peopleNum;
    }

    /**
     * 出动人数
     * @param peopleNum 出动人数
     */
    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    /**
     * 出动车数
     * @return car_num 出动车数
     */
    public Integer getCarNum() {
        return carNum;
    }

    /**
     * 出动车数
     * @param carNum 出动车数
     */
    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    /**
     * 演练经费报备
     * @return rehearse_cost 演练经费报备
     */
    public BigDecimal getRehearseCost() {
        return rehearseCost;
    }

    /**
     * 演练经费报备
     * @param rehearseCost 演练经费报备
     */
    public void setRehearseCost(BigDecimal rehearseCost) {
        this.rehearseCost = rehearseCost;
    }

    /**
     * 演练效果
     * @return effect 演练效果
     */
    public String getEffect() {
        return effect;
    }

    /**
     * 演练效果
     * @param effect 演练效果
     */
    public void setEffect(String effect) {
        this.effect = effect;
    }

    /**
     * 项目id
     * @return project_id 项目id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 项目id
     * @param projectId 项目id
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
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
     * 宣传开始时间
     * @return advertise_start_time 宣传开始时间
     */
    public Date getAdvertiseStartTime() {
        return advertiseStartTime;
    }

    /**
     * 宣传开始时间
     * @param advertiseStartTime 宣传开始时间
     */
    public void setAdvertiseStartTime(Date advertiseStartTime) {
        this.advertiseStartTime = advertiseStartTime;
    }

    /**
     * 宣传结束时间
     * @return advertise_end_time 宣传结束时间
     */
    public Date getAdvertiseEndTime() {
        return advertiseEndTime;
    }

    /**
     * 宣传结束时间
     * @param advertiseEndTime 宣传结束时间
     */
    public void setAdvertiseEndTime(Date advertiseEndTime) {
        this.advertiseEndTime = advertiseEndTime;
    }

    /**
     * 宣传类型
     * @return advertise_type 宣传类型
     */
    public Integer getAdvertiseType() {
        return advertiseType;
    }

    /**
     * 宣传类型
     * @param advertiseType 宣传类型
     */
    public void setAdvertiseType(Integer advertiseType) {
        this.advertiseType = advertiseType;
    }

    /**
     * 宣传范围
     * @return advertise_scope 宣传范围
     */
    public String getAdvertiseScope() {
        return advertiseScope;
    }

    /**
     * 宣传范围
     * @param advertiseScope 宣传范围
     */
    public void setAdvertiseScope(String advertiseScope) {
        this.advertiseScope = advertiseScope;
    }

    /**
     * 宣传经费
     * @return advertise_cost 宣传经费
     */
    public BigDecimal getAdvertiseCost() {
        return advertiseCost;
    }

    /**
     * 宣传经费
     * @param advertiseCost 宣传经费
     */
    public void setAdvertiseCost(BigDecimal advertiseCost) {
        this.advertiseCost = advertiseCost;
    }

    /**
     * 是否逻辑删除0未删除，1已删除
     * @return logic_remove 是否逻辑删除0未删除，1已删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除0未删除，1已删除
     * @param logicRemove 是否逻辑删除0未删除，1已删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
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

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}