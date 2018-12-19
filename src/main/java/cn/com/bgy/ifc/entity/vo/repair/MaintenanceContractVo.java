package cn.com.bgy.ifc.entity.vo.repair;

import java.util.Date;

/**
 * 维保合同分页查询实体
 */
public class MaintenanceContractVo {
    /**合同ID*/
    private Long id;
    /**机构id*/
    private Long orgId;
    /**区域ID*/
    private Long rId;
    /**项目ID*/
    private Long pId;
    /**合同名称*/
    private String contractName;
    /**合同编号*/
    private String contractNo;
    /**维保公司C_Id*/
    private Long companyId;
    /**主联系人*/
    private String masterContact;
    /**联系电话*/
    private String contactPhone;
    /**合同开始日期*/
    private Date startDate;
    /**合同结束日期*/
    private Date endDate;
    /**状态：0有效，1失效，2作废*/
    private Integer state;
    /**创建时间*/
    private Date createTime;
    /**是否逻辑删除*/
    private Boolean logicRemove;
    /**备注信息*/
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getMasterContact() {
        return masterContact;
    }

    public void setMasterContact(String masterContact) {
        this.masterContact = masterContact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}