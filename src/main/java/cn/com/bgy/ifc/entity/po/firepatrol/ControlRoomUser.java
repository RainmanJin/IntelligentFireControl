package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;

public class ControlRoomUser {
    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String phone;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 是否持证
     */
    private Boolean hasProve;

    /**
     * 机构id
     */
    private Long orgId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 
     */
    private Boolean logicRemove;

    /**
     * 主键
     * @return id 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 电话
     * @return phone 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 性别
     * @return sex 性别
     */
    public Boolean getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 是否持证
     * @return has_prove 是否持证
     */
    public Boolean getHasProve() {
        return hasProve;
    }

    /**
     * 是否持证
     * @param hasProve 是否持证
     */
    public void setHasProve(Boolean hasProve) {
        this.hasProve = hasProve;
    }

    /**
     * 机构id
     * @return org_id 机构id
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 机构id
     * @param orgId 机构id
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return logic_remove 
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 
     * @param logicRemove 
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }
}