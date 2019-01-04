package cn.com.bgy.ifc.entity.po.repair;

import java.util.Date;
/**
 * @Author huxin
 * @Description 招修工单信息
 * @Date 2018/12/26 11:24
 */
public class RepairOrder {
    //ID
    private Long id;
    //平台id
    private Long organizationId;
    //机房ID
    private Long computerRoomId;
    //设备ID
    private Long equipmentId;
    //  报修1类型ID
    private Integer mcid;
    //报修人名
    private String repairPerson;
    //报修人电话
    private String repairPersonCall;
    //报修内容
    private String maintaindetail;
    //报修时间
    private Date repairTime;
    //是否紧急   0：不紧急 1表示紧急
    private Boolean isUrgent;
    //工单状态(0：未派单  1：待接单  2：维修中  3：待料中  4：完成维修 5:已销单 6:已取消)
    private Integer state;
    //维修原因
    private String repairReason;
    //维修结果说明
    private String processRemark;
    //维修人
    private String processPerson;
    //维修时间
    private Date processTime;
    //凤凰慧招修订单号
    private String orderNo;
    //凤凰慧招修订单ID
    private Integer extendId;
    //创建时间
    private Date createTime;
    //是否推送到凤凰慧处理  0：未推送  1：推送
    private Boolean isPush;
    //逻辑删除 0：存在  1：删除
    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId( Long organizationId ) {
        this.organizationId = organizationId;
    }

    public Long getComputerRoomId() {
        return computerRoomId;
    }

    public void setComputerRoomId( Long computerRoomId ) {
        this.computerRoomId = computerRoomId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId( Long equipmentId ) {
        this.equipmentId = equipmentId;
    }

    public Integer getMcid() {
        return mcid;
    }

    public void setMcid( Integer mcid ) {
        this.mcid = mcid;
    }

    public String getRepairPerson() {
        return repairPerson;
    }

    public void setRepairPerson( String repairPerson ) {
        this.repairPerson = repairPerson;
    }

    public String getRepairPersonCall() {
        return repairPersonCall;
    }

    public void setRepairPersonCall( String repairPersonCall ) {
        this.repairPersonCall = repairPersonCall;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime( Date repairTime ) {
        this.repairTime = repairTime;
    }

    public Boolean getUrgent() {
        return isUrgent;
    }

    public void setUrgent( Boolean urgent ) {
        isUrgent = urgent;
    }

    public Integer getState() {
        return state;
    }

    public void setState( Integer state ) {
        this.state = state;
    }

    public String getMaintaindetail() {
        return maintaindetail;
    }

    public void setMaintaindetail( String maintaindetail ) {
        this.maintaindetail = maintaindetail;
    }

    public String getRepairReason() {
        return repairReason;
    }

    public void setRepairReason( String repairReason ) {
        this.repairReason = repairReason;
    }

    public String getProcessRemark() {
        return processRemark;
    }

    public void setProcessRemark( String processRemark ) {
        this.processRemark = processRemark;
    }

    public String getProcessPerson() {
        return processPerson;
    }

    public void setProcessPerson( String processPerson ) {
        this.processPerson = processPerson;
    }

    public Date getProcessTime() {
        return processTime;
    }

    public void setProcessTime( Date processTime ) {
        this.processTime = processTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo( String orderNo ) {
        this.orderNo = orderNo;
    }

    public Integer getExtendId() {
        return extendId;
    }

    public void setExtendId( Integer extendId ) {
        this.extendId = extendId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime( Date createTime ) {
        this.createTime = createTime;
    }

    public Boolean getPush() {
        return isPush;
    }

    public void setPush( Boolean push ) {
        isPush = push;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }
}