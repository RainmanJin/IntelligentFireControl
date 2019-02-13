package cn.com.bgy.ifc.entity.po.firepatrol;

public class RegionByRecord implements Serializable{
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
     * 项目ID
     */
    private Long projectId;



    /**
     * 苑区ID
     */
    private Long courtId;



    /**
     * 街道ID
     */
    private Long streetId;


    //楼栋单元ID
    private Long buildingId;

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





    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId( Long buildingId ) {
        this.buildingId = buildingId;
    }

}