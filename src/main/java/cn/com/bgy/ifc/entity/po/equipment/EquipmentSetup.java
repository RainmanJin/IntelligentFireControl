package cn.com.bgy.ifc.entity.po.equipment;

public class EquipmentSetup {
    /**
     * 物联设备ID
     */
    private Long id;

    /**
     * 告警等级 一级-1 二级-2 三级-3
     */
    private Integer grade;

    /**
     * 预警警阀值上限
     */
    private Float valueThresholdMax;

    /**
     * 预警警阀值下限
     */
    private Float valueThresholdMin;

    /**
     * 告警警阀值上限
     */
    private Float alarmThresholdMax;

    /**
     * 告警警阀值下限
     */
    private Float alarmThresholdMin;

    /**
     * 物联设备ID
     * @return id 物联设备ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 物联设备ID
     * @param id 物联设备ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 告警等级 一级-1 二级-2 三级-3
     * @return grade 告警等级 一级-1 二级-2 三级-3
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 告警等级 一级-1 二级-2 三级-3
     * @param grade 告警等级 一级-1 二级-2 三级-3
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 告警警阀值上限
     * @return alarm_threshold_max 告警警阀值上限
     */
    public Float getAlarmThresholdMax() {
        return alarmThresholdMax;
    }

    /**
     * 告警警阀值上限
     * @param alarmThresholdMax 告警警阀值上限
     */
    public void setAlarmThresholdMax(Float alarmThresholdMax) {
        this.alarmThresholdMax = alarmThresholdMax;
    }

    /**
     * 告警警阀值下限
     * @return alarm_threshold_min 告警警阀值下限
     */
    public Float getAlarmThresholdMin() {
        return alarmThresholdMin;
    }

    /**
     * 告警警阀值下限
     * @param alarmThresholdMin 告警警阀值下限
     */
    public void setAlarmThresholdMin(Float alarmThresholdMin) {
        this.alarmThresholdMin = alarmThresholdMin;
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
}