package cn.com.bgy.ifc.entity.po.alarm;

import java.util.Date;

public class AlarmMode {
    /**
     * ID
     */
    private Long id;

    /**
     * 告警名称
     */
    private String name;

    /**
     * 告警类型
     */
    private Integer alarmType;

    /**
     * 启用状态 禁用-0 启用-1
     */
    private Integer state;

    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    /**
     * 告警内容
     */
    private String alarmContent;

    /**
     * ID
     * @return id ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 告警名称
     * @return name 告警名称
     */
    public String getName() {
        return name;
    }

    /**
     * 告警名称
     * @param name 告警名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 告警类型
     * @return alarm_type 告警类型
     */
    public Integer getAlarmType() {
        return alarmType;
    }

    /**
     * 告警类型
     * @param alarmType 告警类型
     */
    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    /**
     * 启用状态 禁用-0 启用-1
     * @return state 启用状态 禁用-0 启用-1
     */
    public Integer getState() {
        return state;
    }

    /**
     * 启用状态 禁用-0 启用-1
     * @param state 启用状态 禁用-0 启用-1
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 创建、修改时间
     * @return create_time 创建、修改时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建、修改时间
     * @param createTime 创建、修改时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 是否逻辑删除
     * @return logic_remove 是否逻辑删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除
     * @param logicRemove 是否逻辑删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    /**
     * 告警内容
     * @return alarm_content 告警内容
     */
    public String getAlarmContent() {
        return alarmContent;
    }

    /**
     * 告警内容
     * @param alarmContent 告警内容
     */
    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }
}