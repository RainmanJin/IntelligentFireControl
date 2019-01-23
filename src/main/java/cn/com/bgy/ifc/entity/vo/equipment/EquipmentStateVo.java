package cn.com.bgy.ifc.entity.vo.equipment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-12 15:24
 **/
public class EquipmentStateVo {

    private Long id;

    /**
     * 设备名称
     */
    @NotBlank(message="设备名称不能为空！")
    @Size(max=100,message="设备名称长度不能超过100字符！")
    private String name;

    /**
     * 设备类型
     */
    @NotNull(message="设备类型不能为空！")
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
     *告警等级 一级-1 二级-2 三级-3
     */
    private Integer grade;
    /**
     *告警警阀值上限
     */
    private Float alarmThresholdMax;

    /**
     *告警警阀值下限
     */
    private Float alarmThresholdMin;

    /**
     * 设备类型查询
     */
    private Integer equipType;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Integer getPartitionNum() {
        return partitionNum;
    }

    public void setPartitionNum(Integer partitionNum) {
        this.partitionNum = partitionNum;
    }

    public Integer getPositionNum() {
        return positionNum;
    }

    public void setPositionNum(Integer positionNum) {
        this.positionNum = positionNum;
    }

    public Integer getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Integer superiorId) {
        this.superiorId = superiorId;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Integer getOnlineTimeOut() {
        return onlineTimeOut;
    }

    public void setOnlineTimeOut(Integer onlineTimeOut) {
        this.onlineTimeOut = onlineTimeOut;
    }

    public String getPlatformDeviceId() {
        return platformDeviceId;
    }

    public void setPlatformDeviceId(String platformDeviceId) {
        this.platformDeviceId = platformDeviceId;
    }

    public String getThirdDeviceId() {
        return thirdDeviceId;
    }

    public void setThirdDeviceId(String thirdDeviceId) {
        this.thirdDeviceId = thirdDeviceId;
    }

    public Float getValueThresholdMax() {
        return valueThresholdMax;
    }

    public void setValueThresholdMax(Float valueThresholdMax) {
        this.valueThresholdMax = valueThresholdMax;
    }

    public Float getValueThresholdMin() {
        return valueThresholdMin;
    }

    public void setValueThresholdMin(Float valueThresholdMin) {
        this.valueThresholdMin = valueThresholdMin;
    }

    public Boolean getCap() {
        return cap;
    }

    public void setCap(Boolean cap) {
        this.cap = cap;
    }

    public Boolean getTilt() {
        return tilt;
    }

    public void setTilt(Boolean tilt) {
        this.tilt = tilt;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public Boolean getHit() {
        return hit;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    public Float getWaterPressure() {
        return waterPressure;
    }

    public void setWaterPressure(Float waterPressure) {
        this.waterPressure = waterPressure;
    }

    public Boolean getValve() {
        return valve;
    }

    public void setValve(Boolean valve) {
        this.valve = valve;
    }

    public Float getFlow() {
        return flow;
    }

    public void setFlow(Float flow) {
        this.flow = flow;
    }

    public Integer getEquipType() {
        return equipType;
    }

    public void setEquipType(Integer equipType) {
        this.equipType = equipType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Float getAlarmThresholdMax() {
        return alarmThresholdMax;
    }

    public void setAlarmThresholdMax(Float alarmThresholdMax) {
        this.alarmThresholdMax = alarmThresholdMax;
    }

    public Float getAlarmThresholdMin() {
        return alarmThresholdMin;
    }

    public void setAlarmThresholdMin(Float alarmThresholdMin) {
        this.alarmThresholdMin = alarmThresholdMin;
    }
}
