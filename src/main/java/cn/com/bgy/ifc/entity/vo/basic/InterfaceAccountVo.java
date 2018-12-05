package cn.com.bgy.ifc.entity.vo.basic;

import java.util.Date;

public class InterfaceAccountVo {
    private Long id;

    private Long orgId;

    private String apiuId;

    private String apiSecret;

    private String name;

    private String chargePerson;

    private String phone;

    private String restrictedIp;

    private Long state;

    private Date createTime;

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

    public String getApiuId() {
        return apiuId;
    }

    public void setApiuId(String apiuId) {
        this.apiuId = apiuId;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChargePerson() {
        return chargePerson;
    }

    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRestrictedIp() {
        return restrictedIp;
    }

    public void setRestrictedIp(String restrictedIp) {
        this.restrictedIp = restrictedIp;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}