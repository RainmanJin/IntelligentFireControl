package cn.com.bgy.ifc.entity.vo.maintenance;

import cn.com.bgy.ifc.entity.vo.project.BgyBaseVo;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台维保合同VO
 * @date: 2018-12-24 10:20
 **/
public class BgyMaintenanceContractVo extends BgyBaseVo {

    /**
     * 区域id
     */
    private Long areaId;
    /**
     * 项目id
     */
    private Long projectId;
    /**
     * 合同名称
     */
    private String name;
    /**
     * 合同编号
     */
    private String contractNum;
    /**
     * 联系方式
     */
    private String telephone;
    /**
     * 维保公司id
     */
    private String companyId;
    /**
     * 主联系人
     */
    private String mainContact;
    /**
     * 合同开始日期
     */
    private String startDay;
    /**
     * 合同结束日期
     */
    private String endDay;
    /**
     * 0有效，1失效，2作废
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private String createTime;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
