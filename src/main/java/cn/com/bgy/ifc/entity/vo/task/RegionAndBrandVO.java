package cn.com.bgy.ifc.entity.vo.task;

/**
 * @Author huxin
 * @Date 2018/12/26 16:29
 * @Description 区域信息和设备信息的查询字段实体
 **/

public class RegionAndBrandVO {

    //区域信息查询条件

    private Long regionId;//区域id

    private Long projectId;//项目id

    private Long courtId; //苑区id

    private Long streetId; //街道id

    private Long buildingId; //楼栋id

    //设备信息查询条件
    private Long typeId;//分类ID

    private Long versionId; // 型号ID

    private Long brandId;//品牌id


    //通用查询
    private String keyword;//关键字

    //特殊查询字段
    private Integer state;//状态

    private String code;//编码

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId( Long regionId ) {
        this.regionId = regionId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId( Long projectId ) {
        this.projectId = projectId;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId( Long courtId ) {
        this.courtId = courtId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId( Long streetId ) {
        this.streetId = streetId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId( Long buildingId ) {
        this.buildingId = buildingId;
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId( Long versionId ) {
        this.versionId = versionId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId( Long brandId ) {
        this.brandId = brandId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId( Long typeId ) {
        this.typeId = typeId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }

    public Integer getState() {
        return state;
    }

    public void setState( int state ) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }
}
