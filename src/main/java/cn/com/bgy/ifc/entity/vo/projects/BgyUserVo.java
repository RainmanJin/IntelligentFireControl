package cn.com.bgy.ifc.entity.vo.projects;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台用户
 * @date: 2018-12-11 17:57
 **/
public class BgyUserVo {

    private Long id;

    /**
     * 手机号码
     */
    private String telephone;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 备注
     */
    private String remark;

    /**
     * 可用标志(0-禁用,1-启用,2-锁定,3-删除)
     */
    private Integer isDisable;

    /**
     * 工号
     */
    private String jobNum;

    /**
     * 身份证号
     */
    private String creditNo;

    private Integer registFrom;

    /**
     * 操作类型(1-新增，2-删除，3-修改)
     */
    private Integer operType;

    /**
     * 操作时间(yyyy-mm-dd HH:mm:ss)
     */
    private String operTime;

    /**
     * 注册时间yyyy-mm-dd hh:mm:ss
     */
    private String registTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDisable() {
        return isDisable;
    }

    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo;
    }

    public Integer getRegistFrom() {
        return registFrom;
    }

    public void setRegistFrom(Integer registFrom) {
        this.registFrom = registFrom;
    }

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    @Override
    public String toString() {
        return "BgyUserVo{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", remark='" + remark + '\'' +
                ", isDisable=" + isDisable +
                ", jobNum='" + jobNum + '\'' +
                ", creditNo='" + creditNo + '\'' +
                ", registFrom=" + registFrom +
                ", operType=" + operType +
                ", operTime='" + operTime + '\'' +
                ", registTime='" + registTime + '\'' +
                '}';
    }
}
