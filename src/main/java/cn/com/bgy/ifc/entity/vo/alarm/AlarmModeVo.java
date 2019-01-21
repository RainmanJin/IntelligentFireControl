package cn.com.bgy.ifc.entity.vo.alarm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:告警方式VO
 * @date: 2019-01-21 12:04
 **/
public class AlarmModeVo {

    private Long id;

    /**
     * 告警名称
     */
    @NotBlank(message="告警名称不能为空！")
    @Size(max=50,message="告警名称长度不能超过50字符！")
    private String name;

    /**
     * 告警类型
     */
    @NotNull(message="告警类型不能为空！")
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

    public Integer getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(Integer alarmType) {
        this.alarmType = alarmType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getAlarmContent() {
        return alarmContent;
    }

    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
    }
}
