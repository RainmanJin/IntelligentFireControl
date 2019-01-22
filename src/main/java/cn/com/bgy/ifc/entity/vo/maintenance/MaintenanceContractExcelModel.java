package cn.com.bgy.ifc.entity.vo.maintenance;

import cn.com.bgy.ifc.entity.vo.common.BgyBaseVo;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台维保合同VO
 * @date: 2018-12-24 10:20
 **/
public class MaintenanceContractExcelModel extends BaseRowModel {

    /**
     * 区域id
     */
    private Long areaId;
    /**
     * 项目id
     */
    private Long projectId;
    @ExcelProperty(value="所属项目",index = 1)
    private String projectName;
    /**
     * 合同名称
     */
    @ExcelProperty(value="合同名称",index = 2)
    private String name;
    /**
     * 合同编号
     */
    @ExcelProperty(value="合同编号",index = 3)
    private String contractNum;
    /**
     * 联系方式
     */
    @ExcelProperty(value="联系电话",index = 5)
    private String telephone;
    /**
     * 维保公司id
     */
    private Long companyId;

    @ExcelProperty(value="维保公司",index = 4)
    private String companyName;
    /**
     * 主联系人
     */
    @ExcelProperty(value="联系人",index = 4)
    private String mainContact;
    /**
     * 合同开始日期
     */
    @ExcelProperty(value="合同开始日期",index = 6)
    private Date startDay;
    /**
     * 合同结束日期
     */
    @ExcelProperty(value="合同结束日期",index = 7)
    private Date endDay;
    /**
     * 0有效，1失效，2作废
     */
    private Integer status;
    @ExcelProperty(value="合同状态",index = 8)
    private String statusName;

    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 合同附件
     */
    private List<BgyMaintenanceContractFileVo> fileList;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
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

    public List<BgyMaintenanceContractFileVo> getFileList() {
        return fileList;
    }

    public void setFileList(List<BgyMaintenanceContractFileVo> fileList) {
        this.fileList = fileList;
    }
}
