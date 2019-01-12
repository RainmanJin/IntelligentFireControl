package cn.com.bgy.ifc.entity.po.equipment;

public class EquipmentConfig {
    /**
     * 
     */
    private Long id;

    /**
     * 设备类型
     */
    private Integer type;

    /**
     * 模拟量类型
     */
    private Integer valueType;

    /**
     * 模拟量单位
     */
    private Integer valueUnitType;

    /**
     * 模拟量上限
     */
    private Float valueThresholdMax;

    /**
     * 模拟量下限
     */
    private Float valueThresholdMin;

    /**
     * 心跳间隔,单位：秒,0:不检查是否在线，>1：在心跳间隔内未收到数据则判断为离线
     */
    private Integer heartbeatInterval;

    /**
     * 设备类型
     */
    private EquipmentType equipmentType;

    /**
     * 模拟量单位
     */
    private AnalogueUnit analogueUnit;

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
     * 设备类型
     * @return type 设备类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设备类型
     * @param type 设备类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 模拟量类型
     * @return value_type 模拟量类型
     */
    public Integer getValueType() {
        return valueType;
    }

    /**
     * 模拟量类型
     * @param valueType 模拟量类型
     */
    public void setValueType(Integer valueType) {
        this.valueType = valueType;
    }

    /**
     * 设备状态描述
     * @return value_unit_type 设备状态描述
     */
    public Integer getValueUnitType() {
        return valueUnitType;
    }

    /**
     * 设备状态描述
     * @param valueUnitType 设备状态描述
     */
    public void setValueUnitType(Integer valueUnitType) {
        this.valueUnitType = valueUnitType;
    }

    /**
     * 模拟量上限
     * @return value_threshold_max 模拟量上限
     */
    public Float getValueThresholdMax() {
        return valueThresholdMax;
    }

    /**
     * 模拟量上限
     * @param valueThresholdMax 模拟量上限
     */
    public void setValueThresholdMax(Float valueThresholdMax) {
        this.valueThresholdMax = valueThresholdMax;
    }

    /**
     * 模拟量下限
     * @return value_threshold_min 模拟量下限
     */
    public Float getValueThresholdMin() {
        return valueThresholdMin;
    }

    /**
     * 模拟量下限
     * @param valueThresholdMin 模拟量下限
     */
    public void setValueThresholdMin(Float valueThresholdMin) {
        this.valueThresholdMin = valueThresholdMin;
    }

    /**
     * 心跳间隔,单位：秒,0:不检查是否在线，>1：在心跳间隔内未收到数据则判断为离线
     * @return heartbeat_interval 心跳间隔,单位：秒,0:不检查是否在线，>1：在心跳间隔内未收到数据则判断为离线
     */
    public Integer getHeartbeatInterval() {
        return heartbeatInterval;
    }

    /**
     * 心跳间隔,单位：秒,0:不检查是否在线，>1：在心跳间隔内未收到数据则判断为离线
     * @param heartbeatInterval 心跳间隔,单位：秒,0:不检查是否在线，>1：在心跳间隔内未收到数据则判断为离线
     */
    public void setHeartbeatInterval(Integer heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public AnalogueUnit getAnalogueUnit() {
        return analogueUnit;
    }

    public void setAnalogueUnit(AnalogueUnit analogueUnit) {
        this.analogueUnit = analogueUnit;
    }
}