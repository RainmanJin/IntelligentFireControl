package cn.com.bgy.ifc.entity.vo.maintenance;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class MaintenanceOrderItemVo {
	private Long id;
    /**维保工单ID**/
	@NotNull(message="维保工单不能为空")
    private Long orderId;
    /**维保计划明细**/
	@NotNull(message="维保计划明细不能为空")
    private Long planDetaiId;
    /**维保项处理结果：1正常，2无需处理，3处理后使用，4无此项**/
	@NotNull(message="维保项处理结果不能为空")
    private Integer resultState;
    /**创建时间**/
    private Date createTime;
    /**是否逻辑删除**/
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