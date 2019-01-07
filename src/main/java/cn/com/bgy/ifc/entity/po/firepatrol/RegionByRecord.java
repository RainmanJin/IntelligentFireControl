package cn.com.bgy.ifc.entity.po.firepatrol;

public class RegionByRecord {
    /**
     * 
     */
    private Long id;


    //装修备案ID
    private Long recordId;

    /**
     * 区域ID
     */
    private Long regionId;

    /**
     * 区域名
     */
    private String regionName;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 苑区ID
     */
    private Long courtId;

    /**
     * 苑区名
     */
    private String courtName;

    /**
     * 街道ID
     */
    private Long streetId;

    /**
     * 街道名
     */
    private String streetName;
    //楼栋单元ID
    private Long buildingId;
    //楼栋单元名
    private long buildingName;
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

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId( Long recordId ) {
        this.recordId = recordId;
    }

    /**
     * 区域ID
     * @return region_id 区域ID
     */
    public Long getRegionId() {
        return regionId;
    }

    /**
     * 区域ID
     * @param regionId 区域ID
     */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    /**
     * 区域名
     * @return region_name 区域名
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * 区域名
     * @param regionName 区域名
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * 项目ID
     * @return project_id 项目ID
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 项目ID
     * @param projectId 项目ID
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 项目名
     * @return project_name 项目名
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 项目名
     * @param projectName 项目名
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 苑区ID
     * @return court_id 苑区ID
     */
    public Long getCourtId() {
        return courtId;
    }

    /**
     * 苑区ID
     * @param courtId 苑区ID
     */
    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    /**
     * 苑区名
     * @return court_name 苑区名
     */
    public String getCourtName() {
        return courtName;
    }

    /**
     * 苑区名
     * @param courtName 苑区名
     */
    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    /**
     * 街道ID
     * @return street_id 街道ID
     */
    public Long getStreetId() {
        return streetId;
    }

    /**
     * 街道ID
     * @param streetId 街道ID
     */
    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    /**
     * 
     * @return street_name 
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * 
     * @param streetName 
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId( Long buildingId ) {
        this.buildingId = buildingId;
    }

    public long getBuildingName() {
        return buildingName;
    }

    public void setBuildingName( long buildingName ) {
        this.buildingName = buildingName;
    }
}