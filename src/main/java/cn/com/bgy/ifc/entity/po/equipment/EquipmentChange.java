package cn.com.bgy.ifc.entity.po.equipment;

import java.util.Date;

public class EquipmentChange {
    /**
     * 
     */
    private Long id;

    /**
     * 设备原始状态值
     */
    private Integer status;

    /**
     * 设备状态记录类型
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
     * 对应的设备状态
     */
    private Integer errorType;

    /**
     * 发生时间
     */
    private Date occuredTime;

    /**
     * 状态描述
     */
    private String description;

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
     * 设备原始状态值
     * @return status 设备原始状态值
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设备原始状态值
     * @param status 设备原始状态值
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 设备状态记录类型
     * @return type 设备状态记录类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设备状态记录类型
     * @param type 设备状态记录类型
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
     * 对应的设备状态
     * @return error_type 对应的设备状态
     */
    public Integer getErrorType() {
        return errorType;
    }

    /**
     * 对应的设备状态
     * @param errorType 对应的设备状态
     */
    public void setErrorType(Integer errorType) {
        this.errorType = errorType;
    }

    /**
     * 发生时间
     * @return occured_time 发生时间
     */
    public Date getOccuredTime() {
        return occuredTime;
    }

    /**
     * 发生时间
     * @param occuredTime 发生时间
     */
    public void setOccuredTime(Date occuredTime) {
        this.occuredTime = occuredTime;
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}