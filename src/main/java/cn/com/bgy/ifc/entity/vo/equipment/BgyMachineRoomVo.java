package cn.com.bgy.ifc.entity.vo.equipment;

import cn.com.bgy.ifc.entity.vo.common.BgyBaseVo;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台机房VO
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
    private Long areaId;
    /**
     *项目id
     */
    private Long projectId;
    /**
     *苑区id
     */
    private Long districtId;
    /**
     *街道id
     */
    private Long streetId;
    /**
     *楼栋id
     */
    private Long buildingId;

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

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
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
