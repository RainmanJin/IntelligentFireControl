package cn.com.bgy.ifc.entity.vo.fireinspection;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-04 15:05
 **/
public class FireTaskDrillVo {

    private Long id;

    /**
     *消防演练任务名称
     */
    private String name;

    /**
     *开始时间
     */
    private Date startTime;

    /**
     *结束时间
     */
    private Date endTime;

    /**
     *地点
     */
    private String place;

    /**
     *指挥人
     */
    private String command;

    /**
     *参与部门
     */
    private String department;

    /**
     *出动人数
     */
    private Integer dispatchedPerson;

    /**
     *出动车数
     */
    private Integer vehiclesDispatched;

    /**
     *消防演练结果
     */
    private String trainResults;

    /**
     *物业名称
     */
    private String propertyName;

    /**
     *区域ID
     */
    private Long regionId;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     *消防演练内容
     */
    private String content;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getDispatchedPerson() {
        return dispatchedPerson;
    }

    public void setDispatchedPerson(Integer dispatchedPerson) {
        this.dispatchedPerson = dispatchedPerson;
    }

    public Integer getVehiclesDispatched() {
        return vehiclesDispatched;
    }

    public void setVehiclesDispatched(Integer vehiclesDispatched) {
        this.vehiclesDispatched = vehiclesDispatched;
    }

    public String getTrainResults() {
        return trainResults;
    }

    public void setTrainResults(String trainResults) {
        this.trainResults = trainResults;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
