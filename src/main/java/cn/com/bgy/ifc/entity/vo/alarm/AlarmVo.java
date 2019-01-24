package cn.com.bgy.ifc.entity.vo.alarm;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:实时告警列表VO
 * @date: 2019-01-19 16:33
 **/
public class AlarmVo {

    private Long id;

    /**
     * 告警等级
     */
    private Integer alarmGrade;

    /**
     * 告警描述
     */
    private String description;

    /**
     * 告警量
     */
    private Integer reportCount;

    /**
     * 告警值
     */
    private Float alarmValue;

    /**
     * 预警参考范围
     */
    private String referenceRange;

    /**
     * 告警参考范围
     */
    private String alarmReferenceRange;

    /**
     * 告警时间
     */
    private Date lastTime;

    /**
     * 告警时长
     */
    private String alarmDuration;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 机房
     */
    private String computerRoomName;

    /**
     * 设备名称
     */
    private String deviceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAlarmGrade() {
        return alarmGrade;
    }

    public void setAlarmGrade(Integer alarmGrade) {
        this.alarmGrade = alarmGrade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public Float getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(Float alarmValue) {
        this.alarmValue = alarmValue;
    }

    public String getReferenceRange() {
        return referenceRange;
    }

    public void setReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getAlarmDuration() {
        return alarmDuration;
    }

    public void setAlarmDuration(String alarmDuration) {
        this.alarmDuration = alarmDuration;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getComputerRoomName() {
        return computerRoomName;
    }

    public void setComputerRoomName(String computerRoomName) {
        this.computerRoomName = computerRoomName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getAlarmReferenceRange() {
        return alarmReferenceRange;
    }

    public void setAlarmReferenceRange(String alarmReferenceRange) {
        this.alarmReferenceRange = alarmReferenceRange;
    }
}
