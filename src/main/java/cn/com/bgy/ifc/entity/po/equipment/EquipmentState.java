package cn.com.bgy.ifc.entity.po.equipment;

public class EquipmentState {
    /**
     * 
     */
    private Long id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备类型
     */
    private Integer type;

    /**
     * 设备状态
     */
    private Integer status;

    /**
     * 设备状态描述
     */
    private String statusDesc;

    /**
     * 区号
     */
    private Integer partitionNum;

    /**
     * 位号
     */
    private Integer positionNum;

    /**
     * 上级设备ID
     */
    private Integer superiorId;

    /**
     * 是否在线
     */
    private Boolean online;

    /**
     * 在线超时心跳时间，单位：秒
     */
    private Integer onlineTimeOut;

    /**
     * OneNet平台设备ID
     */
    private String platformDeviceId;

    /**
     * 三方设备ID，如：序列号，IMEI号，MAC地址等
     */
    private String thirdDeviceId;

    /**
     * 模拟量上限
     */
    private Float valueThresholdMax;

    /**
     * 模拟量下限
     */
    private Float valueThresholdMin;

    /**
     * 消火栓：盖帽打开
     */
    private Boolean cap;

    /**
     * 消火栓：倾斜
     */
    private Boolean tilt;

    /**
     * 消火栓：电池电量%
     */
    private Integer battery;

    /**
     * 消火栓：撞击
     */
    private Boolean hit;

    /**
     * 消火栓：水压MPa
     */
    private Float waterPressure;

    /**
     * 消火栓：阀门打开
     */
    private Boolean valve;

    /**
     * 消火栓：流量
     */
    private Float flow;

    /**
     * 设备类型
     */
    private EquipmentType equipmentType;

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
     * 设备名称
     * @return name 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设备名称
     * @param name 设备名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 设备状态
     * @return status 设备状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设备状态
     * @param status 设备状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 设备状态描述
     * @return status_desc 设备状态描述
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * 设备状态描述
     * @param statusDesc 设备状态描述
     */
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    /**
     * 区号
     * @return partition_num 区号
     */
    public Integer getPartitionNum() {
        return partitionNum;
    }

    /**
     * 区号
     * @param partitionNum 区号
     */
    public void setPartitionNum(Integer partitionNum) {
        this.partitionNum = partitionNum;
    }

    /**
     * 位号
     * @return position_num 位号
     */
    public Integer getPositionNum() {
        return positionNum;
    }

    /**
     * 位号
     * @param positionNum 位号
     */
    public void setPositionNum(Integer positionNum) {
        this.positionNum = positionNum;
    }

    /**
     * 上级设备ID
     * @return superior_id 上级设备ID
     */
    public Integer getSuperiorId() {
        return superiorId;
    }

    /**
     * 上级设备ID
     * @param superiorId 上级设备ID
     */
    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    /**
     * 是否在线
     * @return online 是否在线
     */
    public Boolean getOnline() {
        return online;
    }

    /**
     * 是否在线
     * @param online 是否在线
     */
    public void setOnline(Boolean online) {
        this.online = online;
    }

    /**
     * 在线超时心跳时间，单位：秒
     * @return online_time_out 在线超时心跳时间，单位：秒
     */
    public Integer getOnlineTimeOut() {
        return onlineTimeOut;
    }

    /**
     * 在线超时心跳时间，单位：秒
     * @param onlineTimeOut 在线超时心跳时间，单位：秒
     */
    public void setOnlineTimeOut(Integer onlineTimeOut) {
        this.onlineTimeOut = onlineTimeOut;
    }

    /**
     * OneNet平台设备ID
     * @return platform_device_id OneNet平台设备ID
     */
    public String getPlatformDeviceId() {
        return platformDeviceId;
    }

    /**
     * OneNet平台设备ID
     * @param platformDeviceId OneNet平台设备ID
     */
    public void setPlatformDeviceId(String platformDeviceId) {
        this.platformDeviceId = platformDeviceId;
    }

    /**
     * 三方设备ID，如：序列号，IMEI号，MAC地址等
     * @return third_device_id 三方设备ID，如：序列号，IMEI号，MAC地址等
     */
    public String getThirdDeviceId() {
        return thirdDeviceId;
    }

    /**
     * 三方设备ID，如：序列号，IMEI号，MAC地址等
     * @param thirdDeviceId 三方设备ID，如：序列号，IMEI号，MAC地址等
     */
    public void setThirdDeviceId(String thirdDeviceId) {
        this.thirdDeviceId = thirdDeviceId;
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
     * 消火栓：盖帽打开
     * @return cap 消火栓：盖帽打开
     */
    public Boolean getCap() {
        return cap;
    }

    /**
     * 消火栓：盖帽打开
     * @param cap 消火栓：盖帽打开
     */
    public void setCap(Boolean cap) {
        this.cap = cap;
    }

    /**
     * 消火栓：倾斜
     * @return tilt 消火栓：倾斜
     */
    public Boolean getTilt() {
        return tilt;
    }

    /**
     * 消火栓：倾斜
     * @param tilt 消火栓：倾斜
     */
    public void setTilt(Boolean tilt) {
        this.tilt = tilt;
    }

    /**
     * 消火栓：电池电量%
     * @return battery 消火栓：电池电量%
     */
    public Integer getBattery() {
        return battery;
    }

    /**
     * 消火栓：电池电量%
     * @param battery 消火栓：电池电量%
     */
    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    /**
     * 消火栓：撞击
     * @return hit 消火栓：撞击
     */
    public Boolean getHit() {
        return hit;
    }

    /**
     * 消火栓：撞击
     * @param hit 消火栓：撞击
     */
    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    /**
     * 消火栓：水压MPa
     * @return water_pressure 消火栓：水压MPa
     */
    public Float getWaterPressure() {
        return waterPressure;
    }

    /**
     * 消火栓：水压MPa
     * @param waterPressure 消火栓：水压MPa
     */
    public void setWaterPressure(Float waterPressure) {
        this.waterPressure = waterPressure;
    }

    /**
     * 消火栓：阀门打开
     * @return valve 消火栓：阀门打开
     */
    public Boolean getValve() {
        return valve;
    }

    /**
     * 消火栓：阀门打开
     * @param valve 消火栓：阀门打开
     */
    public void setValve(Boolean valve) {
        this.valve = valve;
    }

    /**
     * 消火栓：流量
     * @return flow 消火栓：流量
     */
    public Float getFlow() {
        return flow;
    }

    /**
     * 消火栓：流量
     * @param flow 消火栓：流量
     */
    public void setFlow(Float flow) {
        this.flow = flow;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
}