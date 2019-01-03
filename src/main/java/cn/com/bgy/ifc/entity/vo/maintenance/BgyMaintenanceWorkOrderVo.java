package cn.com.bgy.ifc.entity.vo.maintenance;

import cn.com.bgy.ifc.entity.vo.common.BgyBaseVo;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台维保工单VO
 * @date: 2018-12-28 15:00
 **/
public class BgyMaintenanceWorkOrderVo extends BgyBaseVo {

    /**
     * 区域id
     */
    private Long areaId;

    /**
     * 项目id
     */
    private Long projectId;

    /**
     * 设备id
     */
    private Long equipmentId;

    /**
     * 维保策略名称（工单名称）
     */
    private String name;
    /**
     * 业务归属
     */
    private Integer standardType;

    /**
     * 维保类型（1半月维保项目、2季度维保项目、3半年维保项目、4年度维保项目）
     */
    private Integer maintenanceType;

    /**
     * 频次
     */
    private Integer orderNum;

    /**
     * 保养日期
     */
    private String workDate;

    /**
     * 公司id
     */
    private Long companyId;

    /**
     * 维保内容，维保项目内容，用||分割
     */
    private String description;

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStandardType() {
        return standardType;
    }

    public void setStandardType(Integer standardType) {
        this.standardType = standardType;
    }

    public Integer getMaintenanceType() {
        return maintenanceType;
    }

    public void setMaintenanceType(Integer maintenanceType) {
        this.maintenanceType = maintenanceType;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
