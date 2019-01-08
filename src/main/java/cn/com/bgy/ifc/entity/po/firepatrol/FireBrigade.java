package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;

public class FireBrigade {
    /**
     * 主键，自动递增
     */
    private Long id;

    /**
     * 消防队名称
     */
    private String fireBrigadeName;

    /**
     * 电话
     */
    private String phone;

    /**
     * 人数
     */
    private Integer peopleNum;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 主要装备，器材
     */
    private String equipment;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 配置时间
     */
    private Date configTime;

    /**
     * 所属区域id
     */
    private Long areaId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除：0未删除，1已删除
     */
    private Boolean logicRemove;

    /**
     * 主键，自动递增
     * @return id 主键，自动递增
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键，自动递增
     * @param id 主键，自动递增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 消防队名称
     * @return fire_brigade_name 消防队名称
     */
    public String getFireBrigadeName() {
        return fireBrigadeName;
    }

    /**
     * 消防队名称
     * @param fireBrigadeName 消防队名称
     */
    public void setFireBrigadeName(String fireBrigadeName) {
        this.fireBrigadeName = fireBrigadeName;
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
     * 人数
     * @return people_num 人数
     */
    public Integer getPeopleNum() {
        return peopleNum;
    }

    /**
     * 人数
     * @param peopleNum 人数
     */
    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    /**
     * 负责人
     * @return principal 负责人
     */
    public String getPrincipal() {
        return principal;
    }

    /**
     * 负责人
     * @param principal 负责人
     */
    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    /**
     * 主要装备，器材
     * @return equipment 主要装备，器材
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * 主要装备，器材
     * @param equipment 主要装备，器材
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * 数量
     * @return count 数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 数量
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 配置时间
     * @return config_time 配置时间
     */
    public Date getConfigTime() {
        return configTime;
    }

    /**
     * 配置时间
     * @param configTime 配置时间
     */
    public void setConfigTime(Date configTime) {
        this.configTime = configTime;
    }

    /**
     * 所属区域id
     * @return area_id 所属区域id
     */
    public Long getAreaId() {
        return areaId;
    }

    /**
     * 所属区域id
     * @param areaId 所属区域id
     */
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
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
     * 是否逻辑删除：0未删除，1已删除
     * @return logic_remove 是否逻辑删除：0未删除，1已删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除：0未删除，1已删除
     * @param logicRemove 是否逻辑删除：0未删除，1已删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }
}