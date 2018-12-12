package cn.com.bgy.ifc.entity.vo.projects;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台用户
 * @date: 2018-12-11 17:57
 **/
public class BgyUserVo extends BgyBaseVo{

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
     * 注册时间yyyy-mm-dd hh:mm:ss
     */
    private String registTime;

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

    public String getRegistTime() {
        return registTime;
    }

    public void setRegistTime(String registTime) {
        this.registTime = registTime;
    }

    @Override
    public String toString() {
        return "BgyUserVo{" +
                "telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                ", remark='" + remark + '\'' +
                ", isDisable=" + isDisable +
                ", jobNum='" + jobNum + '\'' +
                ", creditNo='" + creditNo + '\'' +
                ", registFrom=" + registFrom +
                ", registTime='" + registTime + '\'' +
                '}';
    }
}
