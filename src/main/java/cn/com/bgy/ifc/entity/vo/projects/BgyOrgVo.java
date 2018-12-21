package cn.com.bgy.ifc.entity.vo.projects;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台机构VO
 * @date: 2018-12-20 14:54
 **/
public class BgyOrgVo extends BgyBaseVo {
    /**
     * 公司编码
     */
    private String code;

    /**
     * 区域名称
     */
    private String name;

    /**
     * 公司介绍
     */
    private String description;

    /**
     * 注册时间(yyyy-mm-dd HH:mm:ss)
     */
    private String registerTime;

    /**
     * 法人
     */
    private String legalPerson;

    /**
     * 属性
     */
    private String nature;

    /**
     * 规模
     */
    private String scale;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 座机号码
     */
    private String fixedTelephone;

    /**
     * 注册地址
     */
    private String registerAddress;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 传真
     */
    private String faxNum;

    /**
     * 主页
     */
    private String homePage;

    /**
     * 公司状态(0:未初始化; 1:已初始化)
     */
    private Integer status;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFaxNum() {
        return faxNum;
    }

    public void setFaxNum(String faxNum) {
        this.faxNum = faxNum;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFixedTelephone() {
        return fixedTelephone;
    }

    public void setFixedTelephone(String fixedTelephone) {
        this.fixedTelephone = fixedTelephone;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    @Override
    public String toString() {
        return "BgyOrgVo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", nature='" + nature + '\'' +
                ", scale='" + scale + '\'' +
                ", telephone='" + telephone + '\'' +
                ", fixedTelephone='" + fixedTelephone + '\'' +
                ", registerAddress='" + registerAddress + '\'' +
                ", email='" + email + '\'' +
                ", faxNum='" + faxNum + '\'' +
                ", homePage='" + homePage + '\'' +
                ", status=" + status +
                '}';
    }
}
