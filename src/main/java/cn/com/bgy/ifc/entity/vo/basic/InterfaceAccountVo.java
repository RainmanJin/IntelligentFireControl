package cn.com.bgy.ifc.entity.vo.basic;

import java.util.Date;
/**
 * 接口用户实体
 */
public class InterfaceAccountVo {
    /**
     * 接口用户id
     */
    private Long id;

    /**
     * 机构表C_Id，用于区分平台
     */
    private Long orgId;

    /**
     * 第三方用户唯一凭证
     */
    private String apiuId;

    /**
     * 第三方用户唯一凭证密钥
     */
    private String apiSecret;

    /**
     * 第三方名称
     */
    private String name;

    /**
     * 负责人
     */
    private String chargePerson;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 限制的IP访问地址
     */
    private String restrictedIp;

    /**
     * 0禁用，1启用，2限制IP访问
     */
    private Long state;

    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * interface_account
     */
    private static final long serialVersionUID = 1L;

    /**
     * 接口用户id
     * @return id 接口用户id
     */
    public Long getId() {
        return id;
    }

    /**
     * 接口用户id
     * @param id 接口用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 机构表C_Id，用于区分平台
     * @return org_id 机构表C_Id，用于区分平台
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 机构表C_Id，用于区分平台
     * @param orgId 机构表C_Id，用于区分平台
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 第三方用户唯一凭证
     * @return apiu_id 第三方用户唯一凭证
     */
    public String getApiuId() {
        return apiuId;
    }

    /**
     * 第三方用户唯一凭证
     * @param apiuId 第三方用户唯一凭证
     */
    public void setApiuId(String apiuId) {
        this.apiuId = apiuId == null ? null : apiuId.trim();
    }

    /**
     * 第三方用户唯一凭证密钥
     * @return api_secret 第三方用户唯一凭证密钥
     */
    public String getApiSecret() {
        return apiSecret;
    }

    /**
     * 第三方用户唯一凭证密钥
     * @param apiSecret 第三方用户唯一凭证密钥
     */
    public void setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret == null ? null : apiSecret.trim();
    }

    /**
     * 第三方名称
     * @return name 第三方名称
     */
    public String getName() {
        return name;
    }

    /**
     * 第三方名称
     * @param name 第三方名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 负责人
     * @return charge_person 负责人
     */
    public String getChargePerson() {
        return chargePerson;
    }

    /**
     * 负责人
     * @param chargePerson 负责人
     */
    public void setChargePerson(String chargePerson) {
        this.chargePerson = chargePerson == null ? null : chargePerson.trim();
    }

    /**
     * 联系电话
     * @return phone 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 限制的IP访问地址
     * @return restricted_ip 限制的IP访问地址
     */
    public String getRestrictedIp() {
        return restrictedIp;
    }

    /**
     * 限制的IP访问地址
     * @param restrictedIp 限制的IP访问地址
     */
    public void setRestrictedIp(String restrictedIp) {
        this.restrictedIp = restrictedIp == null ? null : restrictedIp.trim();
    }

    /**
     * 0禁用，1启用，2限制IP访问
     * @return state 0禁用，1启用，2限制IP访问
     */
    public Long getState() {
        return state;
    }

    /**
     * 0禁用，1启用，2限制IP访问
     * @param state 0禁用，1启用，2限制IP访问
     */
    public void setState(Long state) {
        this.state = state;
    }

    /**
     * 创建、修改时间
     * @return create_time 创建、修改时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建、修改时间
     * @param createTime 创建、修改时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}