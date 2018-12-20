package cn.com.bgy.ifc.entity.vo.projects;

/**
 * @author: ZhangCheng
 * @description:集成平台机房
 * @date: 2018-12-19 19:27
 **/
public class BgyMachineRoomVo extends BgyBaseVo {

    /**
     *机房名称
     */
    private String name;
    /**
     *区域id
     */
    private Integer areaId;
    /**
     *项目id
     */
    private Integer projectId;
    /**
     *苑区id
     */
    private Integer districtId;
    /**
     *街道id
     */
    private Integer streetId;
    /**
     *楼栋id
     */
    private Integer buildingId;

    /**
     *编码
     */
    private String code;

    /**
     *地址信息描述(苑区/街道/楼栋)，各部分可能为空
     */
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BgyMachineRoomVo{" +
                "name='" + name + '\'' +
                ", areaId=" + areaId +
                ", projectId=" + projectId +
                ", districtId=" + districtId +
                ", streetId=" + streetId +
                ", buildingId=" + buildingId +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
