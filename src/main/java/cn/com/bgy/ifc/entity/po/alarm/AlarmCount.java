package cn.com.bgy.ifc.entity.po.alarm;

/**
 * @author: ZhangCheng
 * @description:告警统计次数
 * @date: 2019-01-18 17:58
 **/
public class AlarmCount {

    /**
     * 告警
     */
    private Integer report;
    /**
     * 故障
     */
    private Integer hitch;
    /**
     * 隐患
     */
    private Integer hidden;

    public Integer getReport() {
        return report;
    }

    public void setReport(Integer report) {
        this.report = report;
    }

    public Integer getHitch() {
        return hitch;
    }

    public void setHitch(Integer hitch) {
        this.hitch = hitch;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }
}
