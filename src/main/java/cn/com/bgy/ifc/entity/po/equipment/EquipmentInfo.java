/*
*
* EquipmentInfo.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-13
*/
package cn.com.bgy.ifc.entity.po.equipment;

import java.io.Serializable;
import java.util.Date;

public class EquipmentInfo implements Serializable {
    /**
     * 系统自增ID
     */
    private Long id;

    /**
     * 设备名称
     */
    private String name;

    /**
     * 所属机房ID
     */
    private Long inputCode;

    /**
     * 型号ID
     */
    private Long versionId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 所属分类ID
     */
    private Long typeId;

    /**
     * 质保年份
     */
    private Integer keepYears;

    /**
     * 投入使用时间(yyyy-mm-dd)
     */
    private Date inWorkTime;

    /**
     * 是否为重点设备(0-非重点,1-重点)
     */
    private Integer important;

    /**
     * 设备状态 0 停用 1 正常 2报废
     */
    private Integer status;

    /**
     * 位置编号
     */
    private String localtionCode;

    /**
     * 用户辅助编码
     */
    private String simpleCode;

    /**
     * 设备接口编码
     */
    private String apiCode;

    /**
     * 描述
     */
    private String description;

    /**
     * equipment_info
     */
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增ID
     * @return id 系统自增ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 系统自增ID
     * @param id 系统自增ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设备名称
     * @return name 设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设备名称
     * @param name 设备名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所属机房ID
     * @return input_code 所属机房ID
     */
    public Long getInputCode() {
        return inputCode;
    }

    /**
     * 所属机房ID
     * @param inputCode 所属机房ID
     */
    public void setInputCode(Long inputCode) {
        this.inputCode = inputCode;
    }

    /**
     * 型号ID
     * @return version_id 型号ID
     */
    public Long getVersionId() {
        return versionId;
    }

    /**
     * 型号ID
     * @param versionId 型号ID
     */
    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    /**
     * 品牌id
     * @return brand_id 品牌id
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 品牌id
     * @param brandId 品牌id
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 所属分类ID
     * @return type_id 所属分类ID
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 所属分类ID
     * @param typeId 所属分类ID
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 质保年份
     * @return keep_years 质保年份
     */
    public Integer getKeepYears() {
        return keepYears;
    }

    /**
     * 质保年份
     * @param keepYears 质保年份
     */
    public void setKeepYears(Integer keepYears) {
        this.keepYears = keepYears;
    }

    /**
     * 投入使用时间(yyyy-mm-dd)
     * @return in_work_time 投入使用时间(yyyy-mm-dd)
     */
    public Date getInWorkTime() {
        return inWorkTime;
    }

    /**
     * 投入使用时间(yyyy-mm-dd)
     * @param inWorkTime 投入使用时间(yyyy-mm-dd)
     */
    public void setInWorkTime(Date inWorkTime) {
        this.inWorkTime = inWorkTime;
    }

    /**
     * 是否为重点设备(0-非重点,1-重点)
     * @return is_important 是否为重点设备(0-非重点,1-重点)
     */
    public Integer getImportant() {
        return important;
    }

    /**
     * 是否为重点设备(0-非重点,1-重点)
     * @param important 是否为重点设备(0-非重点,1-重点)
     */
    public void setImportant(Integer important) {
        this.important = important;
    }

    /**
     * 设备状态 0 停用 1 正常 2报废
     * @return status 设备状态 0 停用 1 正常 2报废
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设备状态 0 停用 1 正常 2报废
     * @param status 设备状态 0 停用 1 正常 2报废
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 位置编号
     * @return localtion_code 位置编号
     */
    public String getLocaltionCode() {
        return localtionCode;
    }

    /**
     * 位置编号
     * @param localtionCode 位置编号
     */
    public void setLocaltionCode(String localtionCode) {
        this.localtionCode = localtionCode == null ? null : localtionCode.trim();
    }

    /**
     * 用户辅助编码
     * @return simple_code 用户辅助编码
     */
    public String getSimpleCode() {
        return simpleCode;
    }

    /**
     * 用户辅助编码
     * @param simpleCode 用户辅助编码
     */
    public void setSimpleCode(String simpleCode) {
        this.simpleCode = simpleCode == null ? null : simpleCode.trim();
    }

    /**
     * 设备接口编码
     * @return api_code 设备接口编码
     */
    public String getApiCode() {
        return apiCode;
    }

    /**
     * 设备接口编码
     * @param apiCode 设备接口编码
     */
    public void setApiCode(String apiCode) {
        this.apiCode = apiCode == null ? null : apiCode.trim();
    }

    /**
     * 描述
     * @return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}