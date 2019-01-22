package cn.com.bgy.ifc.entity.po.synchro;

import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台用户数据,用于数据同步
 * @date: 2019-01-12 14:30
 **/
public class BgyAccount {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 机构id
     */
    private Long organizationId;
    /**
     * 部门id
     */
    private Long departmentId;

    /**
     * 电话号码
     */
    private String telephone;
    /**
     * 工号
     */
    private String jobNumber;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 密码盐
     */
    private String passwordSalt;
    /**
     * 身份证号
     */
    private String identityNumber;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 注册日期
     */
    private Date registTime;

    /**
     * 第三方用户ID
     */
    private Long thirdUserId;

    /**
     * 是否禁用0启用；1禁用
     */
    private Integer isDisable;

    /**
     * 备注
     */
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Long getThirdUserId() {
        return thirdUserId;
    }

    public void setThirdUserId(Long thirdUserId) {
        this.thirdUserId = thirdUserId;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
