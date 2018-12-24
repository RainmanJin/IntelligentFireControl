package cn.com.bgy.ifc.entity.po.equipment;

/**
 * @Author huxin
 * @Date 2018/12/24 15:08
 * @Description 设备信息视图表对应实体
 **/

public class EquipmentInfoView {
//    CREATE VIEW equipment_info_v as
//    SELECT
//    ei.id as id,
//    ri.id as regionId,ri.`name` as regionName,
//    rp.id as projectId,rp.`name` as projectName,
//    rc.id as courtId,rc.`name` as courtName,
//    rs.id as streetId,rs.`name` as streetName,
//    rb.id as buildingId,rb.`name` as buildingName,
//    ei.`name` as name,
//    ei.input_code as inputCode,
//    et.id as typeId,et.`name` as typeName,
//    eb.id as brandId,eb.`name` as brandName,
//    ev.id as versionId,ev.`name` as versionName,
//    ei.`status` as  `status`
//    FROM equipment_info ei
//    LEFT JOIN region_computer_room rr ON ei.machine_room_id = rr.id
//    LEFT JOIN region_info ri ON rr.region_id = ri.id
//    LEFT JOIN region_project rp ON rr.project_id = rp.id
//    LEFT JOIN region_court rc ON rr.court_id = rc.id
//    LEFT JOIN region_street rs ON rr.street_id = rs.id
//    LEFT JOIN region_building rb ON rr.building_id = rb.id
//    LEFT JOIN equipment_type et ON ei.type_id = et.id
//    LEFT JOIN equipment_brand eb ON ei.brand_id = eb.id
//    LEFT JOIN equipment_version ev ON ei.version_id = ev.id
//    WHERE ei.logic_remove = 0



    //表id对应设备id
    private Long id;
    //区域id
    private Long regionId;
    //区域名
    private String regionName;
    //项目id
    private Long projectId;
    //项目名
    private String projectName;
    //苑区id
    private Long courtId;
    //苑区名
    private String courtName;
    //街道id
    private Long streetId;
    //街道名
    private String streetName;
    //楼栋单元id
    private Long buildingId;
    //楼栋单元名
    private String buildingName;
    //设备名
    private String name;
    //设备编码
    private Long inputCode;
    //设备类型id
    private Long typeId;
    //设备名
    private String typeName;
    //设备品牌id
    private Long brandId;
    //设备品牌名
    private String brandName;
    //设备型号id
    private Long versionId;
    //设备型号名
    private String versionName;
    //设备状态  0停用 1正常 2报废
    private int status;

    //关键字
    private String keyword;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId( Long regionId ) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName( String regionName ) {
        this.regionName = regionName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId( Long projectId ) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName( String projectName ) {
        this.projectName = projectName;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId( Long courtId ) {
        this.courtId = courtId;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName( String courtName ) {
        this.courtName = courtName;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId( Long streetId ) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName( String streetName ) {
        this.streetName = streetName;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId( Long buildingId ) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName( String buildingName ) {
        this.buildingName = buildingName;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Long getInputCode() {
        return inputCode;
    }

    public void setInputCode( Long inputCode ) {
        this.inputCode = inputCode;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId( Long typeId ) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName( String typeName ) {
        this.typeName = typeName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId( Long brandId ) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName( String brandName ) {
        this.brandName = brandName;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId( Long versionId ) {
        this.versionId = versionId;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName( String versionName ) {
        this.versionName = versionName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus( int status ) {
        this.status = status;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}
