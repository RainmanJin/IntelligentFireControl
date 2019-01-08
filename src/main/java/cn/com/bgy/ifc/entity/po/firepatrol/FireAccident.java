package cn.com.bgy.ifc.entity.po.firepatrol;

import java.math.BigDecimal;
import java.util.Date;

public class FireAccident {
    /**
     * 
     */
    private Long id;

    /**
     * 填写人
     */
    private String fillPerson;

    /**
     * 填写时间
     */
    private Date fillTime;

    /**
     * 起火时间
     */
    private Date catchFireTime;

    /**
     * 起火部位
     */
    private String fireLocation;

    /**
     * 直接经济损失（万元）
     */
    private BigDecimal directEconomicLoss;

    /**
     * 间接经济损失（万元）
     */
    private BigDecimal indirectEconomicLosses;

    /**
     * 死亡人数
     */
    private Integer deathToll;

    /**
     * 轻伤人数
     */
    private Integer minorWound;

    /**
     * 重伤人数
     */
    private Integer seriousInjury;

    /**
     * 项目消防安全管理人
     */
    private String custodian;

    /**
     * 项目消防安全责任人
     */
    private String personLiable;

    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * 是否逻辑删除
     */
    private Boolean logicRemove;

    /**
     * 火灾基本情况
     */
    private String fireSituation;

    /**
     * 火灾原因
     */
    private String fireCause;

    /**
     * 烧毁（损）主要财物名称、数量
     */
    private String burnDownProperty;

    /**
     * 烧毁建筑（平方米）
     */
    private String burnDownBuildings;

    /**
     * 处理情况及分析
     */
    private String processing;

    /**
     * 其他
     */
    private String other;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 填写人
     * @return fill_person 填写人
     */
    public String getFillPerson() {
        return fillPerson;
    }

    /**
     * 填写人
     * @param fillPerson 填写人
     */
    public void setFillPerson(String fillPerson) {
        this.fillPerson = fillPerson;
    }

    /**
     * 填写时间
     * @return fill_time 填写时间
     */
    public Date getFillTime() {
        return fillTime;
    }

    /**
     * 填写时间
     * @param fillTime 填写时间
     */
    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
    }

    /**
     * 起火时间
     * @return catch_fire_time 起火时间
     */
    public Date getCatchFireTime() {
        return catchFireTime;
    }

    /**
     * 起火时间
     * @param catchFireTime 起火时间
     */
    public void setCatchFireTime(Date catchFireTime) {
        this.catchFireTime = catchFireTime;
    }

    /**
     * 起火部位
     * @return fire_location 起火部位
     */
    public String getFireLocation() {
        return fireLocation;
    }

    /**
     * 起火部位
     * @param fireLocation 起火部位
     */
    public void setFireLocation(String fireLocation) {
        this.fireLocation = fireLocation;
    }

    /**
     * 直接经济损失（万元）
     * @return direct_economic_loss 直接经济损失（万元）
     */
    public BigDecimal getDirectEconomicLoss() {
        return directEconomicLoss;
    }

    /**
     * 直接经济损失（万元）
     * @param directEconomicLoss 直接经济损失（万元）
     */
    public void setDirectEconomicLoss(BigDecimal directEconomicLoss) {
        this.directEconomicLoss = directEconomicLoss;
    }

    /**
     * 间接经济损失（万元）
     * @return indirect_economic_losses 间接经济损失（万元）
     */
    public BigDecimal getIndirectEconomicLosses() {
        return indirectEconomicLosses;
    }

    /**
     * 间接经济损失（万元）
     * @param indirectEconomicLosses 间接经济损失（万元）
     */
    public void setIndirectEconomicLosses(BigDecimal indirectEconomicLosses) {
        this.indirectEconomicLosses = indirectEconomicLosses;
    }

    /**
     * 死亡人数
     * @return death_toll 死亡人数
     */
    public Integer getDeathToll() {
        return deathToll;
    }

    /**
     * 死亡人数
     * @param deathToll 死亡人数
     */
    public void setDeathToll(Integer deathToll) {
        this.deathToll = deathToll;
    }

    /**
     * 轻伤人数
     * @return minor_wound 轻伤人数
     */
    public Integer getMinorWound() {
        return minorWound;
    }

    /**
     * 轻伤人数
     * @param minorWound 轻伤人数
     */
    public void setMinorWound(Integer minorWound) {
        this.minorWound = minorWound;
    }

    /**
     * 重伤人数
     * @return serious_injury 重伤人数
     */
    public Integer getSeriousInjury() {
        return seriousInjury;
    }

    /**
     * 重伤人数
     * @param seriousInjury 重伤人数
     */
    public void setSeriousInjury(Integer seriousInjury) {
        this.seriousInjury = seriousInjury;
    }

    /**
     * 项目消防安全管理人
     * @return custodian 项目消防安全管理人
     */
    public String getCustodian() {
        return custodian;
    }

    /**
     * 项目消防安全管理人
     * @param custodian 项目消防安全管理人
     */
    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    /**
     * 项目消防安全责任人
     * @return person_liable 项目消防安全责任人
     */
    public String getPersonLiable() {
        return personLiable;
    }

    /**
     * 项目消防安全责任人
     * @param personLiable 项目消防安全责任人
     */
    public void setPersonLiable(String personLiable) {
        this.personLiable = personLiable;
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

    /**
     * 是否逻辑删除
     * @return logic_remove 是否逻辑删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除
     * @param logicRemove 是否逻辑删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    /**
     * 火灾基本情况
     * @return fire_situation 火灾基本情况
     */
    public String getFireSituation() {
        return fireSituation;
    }

    /**
     * 火灾基本情况
     * @param fireSituation 火灾基本情况
     */
    public void setFireSituation(String fireSituation) {
        this.fireSituation = fireSituation;
    }

    /**
     * 火灾原因
     * @return fire_cause 火灾原因
     */
    public String getFireCause() {
        return fireCause;
    }

    /**
     * 火灾原因
     * @param fireCause 火灾原因
     */
    public void setFireCause(String fireCause) {
        this.fireCause = fireCause;
    }

    /**
     * 烧毁（损）主要财物名称、数量
     * @return burn_down_property 烧毁（损）主要财物名称、数量
     */
    public String getBurnDownProperty() {
        return burnDownProperty;
    }

    /**
     * 烧毁（损）主要财物名称、数量
     * @param burnDownProperty 烧毁（损）主要财物名称、数量
     */
    public void setBurnDownProperty(String burnDownProperty) {
        this.burnDownProperty = burnDownProperty;
    }

    /**
     * 烧毁建筑（平方米）
     * @return burn_down_buildings 烧毁建筑（平方米）
     */
    public String getBurnDownBuildings() {
        return burnDownBuildings;
    }

    /**
     * 烧毁建筑（平方米）
     * @param burnDownBuildings 烧毁建筑（平方米）
     */
    public void setBurnDownBuildings(String burnDownBuildings) {
        this.burnDownBuildings = burnDownBuildings;
    }

    /**
     * 处理情况及分析
     * @return processing 处理情况及分析
     */
    public String getProcessing() {
        return processing;
    }

    /**
     * 处理情况及分析
     * @param processing 处理情况及分析
     */
    public void setProcessing(String processing) {
        this.processing = processing;
    }

    /**
     * 其他
     * @return other 其他
     */
    public String getOther() {
        return other;
    }

    /**
     * 其他
     * @param other 其他
     */
    public void setOther(String other) {
        this.other = other;
    }
}