package cn.com.bgy.ifc.entity.po.system;

import java.util.Date;

/**
 * 机构实体
 */
public class SystemOrganization {
    /**
     * 系统自增Id
     */
    private Long id;

    /**
     * 机构名称
     */
    private String name;
    /**
     * 公司编码
     */
    private String code;

    /**
     * 公司介绍
     */
    private String description;

    /**
     * 注册时间(yyyy-mm-dd HH:mm:ss)
     */
    private Date registerTime;

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
     * 状态，0表示禁用；1表示启用
     */
    private Integer state;

    /**
     * 机构管理员，用户表Id
     */
    private Long userId;

    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;
    /**
     * 关键字
     */
    private String keyWords;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * 系统自增Id
     *
     * @return id 系统自增Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 系统自增Id
     *
     * @param id 系统自增Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 机构名称
     *
     * @return name 机构名称
     */
    public String getName() {
        return name;
    }

    /**
     * 机构名称
     *
     * @param name 机构名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 状态，0表示禁用；1表示启用
     *
     * @return state 状态，0表示禁用；1表示启用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态，0表示禁用；1表示启用
     *
     * @param state 状态，0表示禁用；1表示启用
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 机构管理员，用户表Id
     *
     * @return user_id 机构管理员，用户表Id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 机构管理员，用户表Id
     *
     * @param userId 机构管理员，用户表Id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 创建、修改时间
     *
     * @return create_time 创建、修改时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建、修改时间
     *
     * @param createTime 创建、修改时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 是否逻辑删除
     *
     * @return logic_remove 是否逻辑删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除
     *
     * @param logicRemove 是否逻辑删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
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

}