package cn.com.bgy.ifc.entity.po.equipment;

import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.po.project.RegionProject;

import java.util.Date;

public class EquipmentEvent {
    /**
     * 
     */
    private Long id;

    /**
     * 事件状态
     */
    private Integer status;

    /**
     * 事件类型
     */
    private Integer type;

    /**
     * 设备ID
     */
    private Long deviceId;

    /**
     * 设备名称
     */
    private String deviceName;

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
     * 集成平台设备信息
     */
    private EquipmentInfo equipmentInfo;

    /**
     * 机房信息
     */
    private RegionComputerRoom regionComputerRoom;

    /**
     * 项目信息
     */
    private RegionProject regionProject;

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
     * 事件状态
     * @return status 事件状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 事件状态
     * @param status 事件状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 事件类型
     * @return type 事件类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 事件类型
     * @param type 事件类型
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
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

    public RegionProject getRegionProject() {
        return regionProject;
    }

    public void setRegionProject(RegionProject regionProject) {
        this.regionProject = regionProject;
    }
}