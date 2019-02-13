package cn.com.bgy.ifc.entity.po.alarm;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.project.RegionProject;

import java.util.Date;

public class RealTimeAlarm {
    /**
     * ID自增
     */
    private Long id;

    /**
     * 状态 未处理:0 已处理:1
     */
    private Integer status;

    /**
     * 告警类型 火警:1 告警:2 隐患:3 
     */
    private Integer type;

    /**
     * 设备ID
     */
    private Long deviceId;

    /**
     * 第一次产生时间
     */
    private Date firstTime;

    /**
     * 最近一次产生时间
     */
    private Date lastTime;

    /**
     * 状态描述
     */
    private String description;

    /**
     * 上报次数
     */
    private Integer reportCount;

    /**
     * 物联事件ID
     */
    private Long eventId;

    /**
     * 告警值
     */
    private Float alarmValue;

    /**
     * 集成平台设备信息
     */
    private EquipmentInfo equipmentInfo;

    /**
     * 机房信息
     */
    private RegionComputerRoom regionComputerRoom;

    /**
     * 区域信息
     */
    private RegionInfo regionInfo;
    /**
     * 项目信息
     */
    private RegionProject regionProject;

    /**
     * 物联设备信息
     */
    private EquipmentState equipmentState;

    /**
     * ID自增
     * @return id ID自增
     */
    public Long getId() {
        return id;
    }

    /**
     * ID自增
     * @param id ID自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 状态 未处理:0 已处理:1
     * @return status 状态 未处理:0 已处理:1
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 未处理:0 已处理:1
     * @param status 状态 未处理:0 已处理:1
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 告警类型 火警:1 告警:2 隐患:3 
     * @return type 告警类型 火警:1 告警:2 隐患:3 
     */
    public Integer getType() {
        return type;
    }

    /**
     * 告警类型 火警:1 告警:2 隐患:3 
     * @param type 告警类型 火警:1 告警:2 隐患:3 
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 设备ID
     * @return device_id 设备ID
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * 设备ID
     * @param deviceId 设备ID
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 第一次产生时间
     * @return first_time 第一次产生时间
     */
    public Date getFirstTime() {
        return firstTime;
    }

    /**
     * 第一次产生时间
     * @param firstTime 第一次产生时间
     */
    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    /**
     * 最近一次产生时间
     * @return last_time 最近一次产生时间
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 最近一次产生时间
     * @param lastTime 最近一次产生时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 状态描述
     * @return description 状态描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 状态描述
     * @param description 状态描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 上报次数
     * @return report_count 上报次数
     */
    public Integer getReportCount() {
        return reportCount;
    }

    /**
     * 上报次数
     * @param reportCount 上报次数
     */
    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    /**
     * 物联事件ID
     * @return event_id 物联事件ID
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * 物联事件ID
     * @param eventId 物联事件ID
     */
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public EquipmentInfo getEquipmentInfo() {
        return equipmentInfo;
    }

    public void setEquipmentInfo(EquipmentInfo equipmentInfo) {
        this.equipmentInfo = equipmentInfo;
    }

    public RegionComputerRoom getRegionComputerRoom() {
        return regionComputerRoom;
    }

    public void setRegionComputerRoom(RegionComputerRoom regionComputerRoom) {
        this.regionComputerRoom = regionComputerRoom;
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

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(EquipmentState equipmentState) {
        this.equipmentState = equipmentState;
    }

    public Float getAlarmValue() {
        return alarmValue;
    }

    public void setAlarmValue(Float alarmValue) {
        this.alarmValue = alarmValue;
    }
}