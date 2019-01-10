package cn.com.bgy.ifc.entity.po.firepatrol;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @Author huxin
 * @Description 装修垃圾清理情况
 * @Date 2019/1/5 16:43
 */
public class RenovationRecord {
    //id
    private Long id;
    //地址
    private String address;
    //建筑面积
    private BigDecimal acreage;
    //房产性质0住宅1非住宅
    private Integer nature;
    //产权人
    private String propertyOwner;
    //产权人联系电话
    private String propertyOwnerTel;
    //申请人
    private String proposer;
    //申请人联系电话
    private String proposerTel;
    //装修方式：0自己装修 1委托装修公司
    private Integer decorationMethod;
    //装修开始时间
    private Date startTime;
    //装修结束时间
    private Date endTime;
    //装修内容说明
    private String description;
    //负责人
    private String responsiblePerson;
    //负责人联系电话
    private String responsiblePersonTel;
    //备注
    private String remark;
    //是否动火0：否 1：是
    private Boolean isFire;
    //附近是否存在消防设施 0：否  1：是
    private Boolean isFireFacilities;
    //创建、修改时间
    private Date createTime;
    //是否逻辑删除    0:存在    1:删除
    private Boolean logicRemove;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public void setAcreage( BigDecimal acreage ) {
        this.acreage = acreage;
    }

    public Integer getNature() {
        return nature;
    }

    public void setNature( Integer nature ) {
        this.nature = nature;
    }

    public String getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner( String propertyOwner ) {
        this.propertyOwner = propertyOwner;
    }

    public String getPropertyOwnerTel() {
        return propertyOwnerTel;
    }

    public void setPropertyOwnerTel( String propertyOwnerTel ) {
        this.propertyOwnerTel = propertyOwnerTel;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer( String proposer ) {
        this.proposer = proposer;
    }

    public String getProposerTel() {
        return proposerTel;
    }

    public void setProposerTel( String proposerTel ) {
        this.proposerTel = proposerTel;
    }

    public Integer getDecorationMethod() {
        return decorationMethod;
    }

    public void setDecorationMethod( Integer decorationMethod ) {
        this.decorationMethod = decorationMethod;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime( Date startTime ) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime( Date endTime ) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson( String responsiblePerson ) {
        this.responsiblePerson = responsiblePerson;
    }

    public String getResponsiblePersonTel() {
        return responsiblePersonTel;
    }

    public void setResponsiblePersonTel( String responsiblePersonTel ) {
        this.responsiblePersonTel = responsiblePersonTel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark( String remark ) {
        this.remark = remark;
    }

    public Boolean getIsFire() {
        return isFire;
    }

    public void setIsFire( Boolean isFire ) {
        this.isFire = isFire;
    }

    public Boolean getIsFireFacilities() {
        return isFireFacilities;
    }

    public void setIsFireFacilities( Boolean isFireFacilities ) {
        this.isFireFacilities = isFireFacilities;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime( Date createTime ) {
        this.createTime = createTime;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }
}