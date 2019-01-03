package cn.com.bgy.ifc.entity.vo.fireinspection;

import java.util.Date;

public class FirePlanTestVo {
    private Long id;

    private Integer status;

    private Boolean logicRemove;

    private Integer planCycle;

    private Date createTime;

    private Date beginTime;

    private Date endTime;

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

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public Integer getPlanCycle() {
        return planCycle;
    }

    public void setPlanCycle(Integer planCycle) {
        this.planCycle = planCycle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}