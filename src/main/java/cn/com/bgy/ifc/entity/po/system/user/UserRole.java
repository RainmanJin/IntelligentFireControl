package cn.com.bgy.ifc.entity.po.system.user;

/**
 * 用户角色
 */
public class UserRole {
    /**
     * id
     */
    private Long id;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 账号
     */
    private String telephone;
    /**
     * 工号
     */
    private String jobNumber;
    /**
     * 部门名称
     */
    private String dpartmentName;
    /**
     * 部门Id
     */
    private Long dpartmentId;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 所具备角色类型
     * 用户类型(0一般用户,1机构管理员,2系统管理员,3技术管理员)
     */
    private Integer type;
    /**
     *关键字
     */
    private String keyWords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getDpartmentName() {
        return dpartmentName;
    }

    public void setDpartmentName(String dpartmentName) {
        this.dpartmentName = dpartmentName;
    }

    public Long getDpartmentId() {
        return dpartmentId;
    }

    public void setDpartmentId(Long dpartmentId) {
        this.dpartmentId = dpartmentId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
