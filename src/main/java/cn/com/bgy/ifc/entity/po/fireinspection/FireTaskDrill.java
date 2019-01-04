package cn.com.bgy.ifc.entity.po.fireinspection;

import java.util.Date;

public class FireTaskDrill {
    private Long id;

    private String name;

    private Date startTime;

    private Date endTime;

    private String place;

    private String command;

    private String department;

    private Integer dispatchedPerson;

    private Integer vehiclesDispatched;

    private String trainResults;

    private String propertyName;

    private Long regionId;

    private Date createTime;

    private Boolean logicRemove;

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

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}