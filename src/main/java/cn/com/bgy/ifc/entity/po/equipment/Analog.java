package cn.com.bgy.ifc.entity.po.equipment;

import java.util.Date;

public class Analog {
    private Long id;

    /**
     * 模拟量类型
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
     * 模拟量异常类型
     */
    private Integer errorType;

    /**
     * 采集时间
     */
    private Date caputureTime;

    /**
     * 模拟量值
     */
    private Float value;

    /**
     * 单位类型
     */
    private Integer unitType;

    /**
     * 模拟量单位类型
     */
    private AnalogueUnit analogueUnit;

    /**
     * 模拟量类型
     * @return id 模拟量类型
     */
    public Long getId() {
        return id;
    }

    /**
     * 模拟量类型
     * @param id 模拟量类型
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 模拟量类型
     * @return type 模拟量类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 模拟量类型
     * @param type 模拟量类型
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
     * 模拟量异常类型
     * @return error_type 模拟量异常类型
     */
    public Integer getErrorType() {
        return errorType;
    }

    /**
     * 模拟量异常类型
     * @param errorType 模拟量异常类型
     */
    public void setErrorType(Integer errorType) {
        this.errorType = errorType;
    }

    /**
     * 采集时间
     * @return caputure_time 采集时间
     */
    public Date getCaputureTime() {
        return caputureTime;
    }

    /**
     * 采集时间
     * @param caputureTime 采集时间
     */
    public void setCaputureTime(Date caputureTime) {
        this.caputureTime = caputureTime;
    }

    /**
     * 模拟量值
     * @return value 模拟量值
     */
    public Float getValue() {
        return value;
    }

    /**
     * 模拟量值
     * @param value 模拟量值
     */
    public void setValue(Float value) {
        this.value = value;
    }

    /**
     * 单位类型
     * @return unit_type 单位类型
     */
    public Integer getUnitType() {
        return unitType;
    }

    /**
     * 单位类型
     * @param unitType 单位类型
     */
    public void setUnitType(Integer unitType) {
        this.unitType = unitType;
    }

    public AnalogueUnit getAnalogueUnit() {
        return analogueUnit;
    }

    public void setAnalogueUnit(AnalogueUnit analogueUnit) {
        this.analogueUnit = analogueUnit;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
}