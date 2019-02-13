package cn.com.bgy.ifc.entity.po.firepatrol;

public class MaintenanceQualifications implements Serializable{
    /**
     * 主键
     */
    private Long id;

    /**
     * 区域ID
     */
    private Integer regionId;

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 设备名
     */
    private String equipmentName;

    /**
     * 维保公司名
     */
    private String companyName;

    /**
     * 资质
     */
    private String qualifications;

    //是否逻辑删除    0:存在    1:删除
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
     * 区域ID
     * @return region_id 区域ID
     */
    public Integer getRegionId() {
        return regionId;
    }

    /**
     * 区域ID
     * @param regionId 区域ID
     */
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    /**
     * 项目ID
     * @return project_id 项目ID
     */
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * 项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    /**
     * 设备名
     * @return equipment_name 设备名
     */
    public String getEquipmentName() {
        return equipmentName;
    }

    /**
     * 设备名
     * @param equipmentName 设备名
     */
    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    /**
     * 维保公司名
     * @return company_name 维保公司名
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 维保公司名
     * @param companyName 维保公司名
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 资质
     * @return qualifications 资质
     */
    public String getQualifications() {
        return qualifications;
    }

    /**
     * 资质
     * @param qualifications 资质
     */
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }


    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }
}