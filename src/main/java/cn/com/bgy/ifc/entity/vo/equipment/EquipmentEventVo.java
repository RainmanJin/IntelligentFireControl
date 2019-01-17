package cn.com.bgy.ifc.entity.vo.equipment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-15 17:55
 **/
public class EquipmentEventVo {

    private Long id;

    /**
     * 事件状态
     */
    @NotNull(message="事件状态不能为空！")
    private Integer status;

    /**
     * 事件类型
     */
    @NotNull(message="事件类型不能为空！")
    private Integer type;

    /**
     * 设备ID
     */
    @NotNull(message="设备编号不能为空！")
    private Long deviceId;

    /**
     * 第一次产生时间
     */
    @NotNull(message="第一次产生时间不能为空！")
    private Date firstTime;

    /**
     * 最近一次产生时间
     */
    @NotNull(message="最近一次产生时间不能为空！")
    private Date lastTime;

    /**
     * 状态描述
     */
    @NotBlank(message="状态描述不能为空！")
    @Size(max=100,message="状态描述长度不能超过100字符！")
    private String description;

    /**
     * 上报次数
     */
    @NotNull(message="上报次数不能为空！")
    private Integer reportCount;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
