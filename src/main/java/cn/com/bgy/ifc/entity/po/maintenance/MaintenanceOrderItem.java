package cn.com.bgy.ifc.entity.po.maintenance;

import java.util.Date;

public class MaintenanceOrderItem {
    private Long id;

    private Long orderId;

    private Long planDetaiId;

    private Integer resultState;

    private Date createTime;

    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getPlanDetaiId() {
        return planDetaiId;
    }

    public void setPlanDetaiId(Long planDetaiId) {
        this.planDetaiId = planDetaiId;
    }

    public Integer getResultState() {
        return resultState;
    }

    public void setResultState(Integer resultState) {
        this.resultState = resultState;
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
}