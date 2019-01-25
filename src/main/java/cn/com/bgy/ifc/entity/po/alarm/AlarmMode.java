package cn.com.bgy.ifc.entity.po.alarm;

import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.project.RegionProject;

import java.util.Date;

public class AlarmMode {
    /**
     * ID
     */
    private Long id;

    /**
     * 所属区域ID
     */
    private Long regionId;

    /**
     * 所属项目ID
     */
    private Long projectId;

    /**
     * 火警告警方式
     */
    private String fireAlarm;

    /**
     * 一级告警告警方式
     */
    private String oneLevelAlarm;

    /**
     * 二级告警告警方式
     */
    private String twoLevelAlarm;

    /**
     * 三级告警告警方式
     */
    private String threeLevelAlarm;

    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    /**
     * 所属区域
     */
    private RegionInfo regionInfo;

    /**
     * 所属项目
     */
    private RegionProject regionProject;

    /**
     * ID
     * @return id ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * 所属项目ID
     * @return project_id 所属项目ID
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 所属项目ID
     * @param projectId 所属项目ID
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 火警告警方式
     * @return fire_alarm 火警告警方式
     */
    public String getFireAlarm() {
        return fireAlarm;
    }

    /**
     * 火警告警方式
     * @param fireAlarm 火警告警方式
     */
    public void setFireAlarm(String fireAlarm) {
        this.fireAlarm = fireAlarm;
    }

    /**
     * 一级告警告警方式
     * @return one_level_alarm 一级告警告警方式
     */
    public String getOneLevelAlarm() {
        return oneLevelAlarm;
    }

    /**
     * 一级告警告警方式
     * @param oneLevelAlarm 一级告警告警方式
     */
    public void setOneLevelAlarm(String oneLevelAlarm) {
        this.oneLevelAlarm = oneLevelAlarm;
    }

    /**
     * 二级告警告警方式
     * @return two_level_alarm 二级告警告警方式
     */
    public String getTwoLevelAlarm() {
        return twoLevelAlarm;
    }

    /**
     * 二级告警告警方式
     * @param twoLevelAlarm 二级告警告警方式
     */
    public void setTwoLevelAlarm(String twoLevelAlarm) {
        this.twoLevelAlarm = twoLevelAlarm;
    }

    /**
     * 三级告警告警方式
     * @return three_level_alarm 三级告警告警方式
     */
    public String getThreeLevelAlarm() {
        return threeLevelAlarm;
    }

    /**
     * 三级告警告警方式
     * @param threeLevelAlarm 三级告警告警方式
     */
    public void setThreeLevelAlarm(String threeLevelAlarm) {
        this.threeLevelAlarm = threeLevelAlarm;
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

    public RegionInfo getRegionInfo() {
        return regionInfo;
    }

    public void setRegionInfo(RegionInfo regionInfo) {
        this.regionInfo = regionInfo;
    }

    public RegionProject getRegionProject() {
        return regionProject;
    }

    public void setRegionProject(RegionProject regionProject) {
        this.regionProject = regionProject;
    }
}