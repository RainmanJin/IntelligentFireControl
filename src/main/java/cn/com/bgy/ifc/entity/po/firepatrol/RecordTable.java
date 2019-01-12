package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;

public class RecordTable {
    /**
     * id
     */
    private Long id;

    /**
     * 设施设备ID
     */
    private Long equipmentId;

    /**
     * 工单ID
     */
    private Long orderId;

    /**
     * 情况  0:正常 1：异常
     */
    private Integer situation;

    /**
     * 描述
     */
    private String description;

    /**
     * 
 类别  1：巡检  2：维保  3：检测
     */
    private Integer type;

    /**
     * 填写人
     */
    private String recordPerson;

    /**
     * 审核人
 
     */
    private String approver;

    /**
     * 审核结果 
     */
    private String approvalResult;

    /**
     * 是否逻辑删除  0:存在  1：删除
     */
    private Boolean logicRemove;

    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * id
     * @return id id
     */
    public Long getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设施设备ID
     * @return equipment_id 设施设备ID
     */
    public Long getEquipmentId() {
        return equipmentId;
    }

    /**
     * 设施设备ID
     * @param equipmentId 设施设备ID
     */
    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * 工单ID
     * @return order_id 工单ID
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 工单ID
     * @param orderId 工单ID
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 情况  0:正常 1：异常
     * @return situation 情况  0:正常 1：异常
     */
    public Integer getSituation() {
        return situation;
    }

    /**
     * 情况  0:正常 1：异常
     * @param situation 情况  0:正常 1：异常
     */
    public void setSituation(Integer situation) {
        this.situation = situation;
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
 类别  1：巡检  2：维保  3：检测
     * @return type 
 类别  1：巡检  2：维保  3：检测
     */
    public Integer getType() {
        return type;
    }

    /**
     * 
 类别  1：巡检  2：维保  3：检测
     * @param type 
 类别  1：巡检  2：维保  3：检测
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 填写人
     * @return record_person 填写人
     */
    public String getRecordPerson() {
        return recordPerson;
    }

    /**
     * 填写人
     * @param recordPerson 填写人
     */
    public void setRecordPerson(String recordPerson) {
        this.recordPerson = recordPerson;
    }

    /**
     * 审核人
 
     * @return approver 审核人
 
     */
    public String getApprover() {
        return approver;
    }

    /**
     * 审核人
 
     * @param approver 审核人
 
     */
    public void setApprover(String approver) {
        this.approver = approver;
    }

    /**
     * 审核结果 
     * @return approval_result 审核结果 
     */
    public String getApprovalResult() {
        return approvalResult;
    }

    /**
     * 审核结果 
     * @param approvalResult 审核结果 
     */
    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
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