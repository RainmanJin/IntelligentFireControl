package cn.com.bgy.ifc.entity.po.system.user;

import java.io.Serializable;

/**
 * 用户权限
 */
public class SystemUserPower implements Serializable {
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
     * 所具备权限
     */
    private String powerName;
    /**
     *关键字
     */
    private String keyWords;

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    public Long getDpartmentId() {
        return dpartmentId;
    }

    public void setDpartmentId(Long dpartmentId) {
        this.dpartmentId = dpartmentId;
    }
}
