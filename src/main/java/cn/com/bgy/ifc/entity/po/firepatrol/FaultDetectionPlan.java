package cn.com.bgy.ifc.entity.po.firepatrol;

import java.io.Serializable;
import java.util.Date;

public class FaultDetectionPlan implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 设施故障记录表ID
     */
    private Long recordId;

    /**
     * 计划名
     */
    private String planName;

    /**
     * 计划周期类型/次（1每日、2每周、3月度、4季度、
 5半年、6年度）
 
     */
    private Integer planType;

    /**
     * 计划执行状态  0：未开始  1：执行中  2：已完成
 
     */
    private String planStatus;

    /**
     * 是否逻辑删除  0:存在  1：删除
     */
    private Boolean logicRemove;

    /**
     * 创建、修改时间
     */
    private Date createTime;

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
     * 设施故障记录表ID
     * @return record_id 设施故障记录表ID
     */
    public Long getRecordId() {
        return recordId;
    }

    /**
     * 设施故障记录表ID
     * @param recordId 设施故障记录表ID
     */
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    /**
     * 计划名
     * @return plan_name 计划名
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * 计划名
     * @param planName 计划名
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * 计划周期类型/次（1每日、2每周、3月度、4季度、
 5半年、6年度）
 
     * @return plan_type 计划周期类型/次（1每日、2每周、3月度、4季度、
 5半年、6年度）
 
     */
    public Integer getPlanType() {
        return planType;
    }

    /**
     * 计划周期类型/次（1每日、2每周、3月度、4季度、
 5半年、6年度）
 
     * @param planType 计划周期类型/次（1每日、2每周、3月度、4季度、
 5半年、6年度）
 
     */
    public void setPlanType(Integer planType) {
        this.planType = planType;
    }

    /**
     * 计划执行状态  0：未开始  1：执行中  2：已完成
 
     * @return plan_status 计划执行状态  0：未开始  1：执行中  2：已完成
 
     */
    public String getPlanStatus() {
        return planStatus;
    }

    /**
     * 计划执行状态  0：未开始  1：执行中  2：已完成
 
     * @param planStatus 计划执行状态  0：未开始  1：执行中  2：已完成
 
     */
    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    /**
     * 是否逻辑删除  0:存在  1：删除
     * @return logic_remove 是否逻辑删除  0:存在  1：删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除  0:存在  1：删除
     * @param logicRemove 是否逻辑删除  0:存在  1：删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
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
}