package cn.com.bgy.ifc.entity.vo.alarm;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:告警方式VO
 * @date: 2019-01-21 12:04
 **/
public class AlarmModeVo {

    /**
     * ID
     */
    private Long id;

    /**
     * 所属区域ID
     */
    @NotNull(message="所属区域不能为空！")
    private Long regionId;

    /**
     * 所属项目ID
     */
    @NotNull(message="所属项目不能为空！")
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
     * 关键字
     */
    private String keyword;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getFireAlarm() {
        return fireAlarm;
    }

    public void setFireAlarm(String fireAlarm) {
        this.fireAlarm = fireAlarm;
    }

    public String getOneLevelAlarm() {
        return oneLevelAlarm;
    }

    public void setOneLevelAlarm(String oneLevelAlarm) {
        this.oneLevelAlarm = oneLevelAlarm;
    }

    public String getTwoLevelAlarm() {
        return twoLevelAlarm;
    }

    public void setTwoLevelAlarm(String twoLevelAlarm) {
        this.twoLevelAlarm = twoLevelAlarm;
    }

    public String getThreeLevelAlarm() {
        return threeLevelAlarm;
    }

    public void setThreeLevelAlarm(String threeLevelAlarm) {
        this.threeLevelAlarm = threeLevelAlarm;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String toString() {
        return "AlarmModeVo{" +
                "id=" + id +
                ", regionId=" + regionId +
                ", projectId=" + projectId +
                ", fireAlarm='" + fireAlarm + '\'' +
                ", oneLevelAlarm='" + oneLevelAlarm + '\'' +
                ", twoLevelAlarm='" + twoLevelAlarm + '\'' +
                ", threeLevelAlarm='" + threeLevelAlarm + '\'' +
                ", createTime=" + createTime +
                ", logicRemove=" + logicRemove +
                '}';
    }
}
