package cn.com.bgy.ifc.entity.vo.equipment;

import javax.validation.constraints.NotNull;

/**
 * @author: ZhangCheng
 * @description:设备配置
 * @date: 2019-01-10 14:28
 **/
public class EquipmentConfigVo {

    /**
     *
     */
    private Long id;

    /**
     * 设备类型
     */
    @NotNull(message="设备类型不能为空！")
    private Integer type;

    /**
     * 模拟量单位
     */
    private Integer valueType;

    /**
     * 设备状态描述
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValueType() {
        return valueType;
    }

    public void setValueType(Integer valueType) {
        this.valueType = valueType;
    }

    public Integer getValueUnitType() {
        return valueUnitType;
    }

    public void setValueUnitType(Integer valueUnitType) {
        this.valueUnitType = valueUnitType;
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

    public Integer getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public void setHeartbeatInterval(Integer heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }
}
