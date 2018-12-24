package cn.com.bgy.ifc.entity.vo.project;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台项目列表
 * @date: 2018-12-12 11:50
 **/
public class BgyProjectVo extends BgyBaseVo {

    /**
     * 项目名称
     */
    private String name;
    /**
     * 区域id
     */
    private Long areaId;
    /**
     * 项目编码
     */
    private String code;
    /**
     * 定位的经纬度(例：116.167292,24.273523)
     */
    private String locationStr;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocationStr() {
        return locationStr;
    }

    public void setLocationStr(String locationStr) {
        this.locationStr = locationStr;
    }

    @Override
    public String toString() {
        return "BgyProjectVo{" +
                "name='" + name + '\'' +
                ", areaId=" + areaId +
                ", code='" + code + '\'' +
                ", locationStr='" + locationStr + '\'' +
                '}';
    }
}
