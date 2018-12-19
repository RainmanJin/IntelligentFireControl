package cn.com.bgy.ifc.entity.vo.basic.region;

import java.util.Date;

public class RegionProjectVo {
    /**
     * @Author huxin
     * @Description ID
     * @Date 2018/12/18 17:53
     */
    private Long id;
    /**
     * @Author huxin
     * @Description 平台ID
     * @Date 2018/12/18 17:53
     */
    private Long organizationId;
    /**
     * @Author huxin
     * @Description 区域ID
     * @Date 2018/12/18 17:54
     */
    private Long regionId;
    /**
     * @Author huxin
     * @Description 编码
     * @Date 2018/12/18 17:54
     */
    private String code;
    /**
     * @Author huxin
     * @Description 项目名
     * @Date 2018/12/18 17:54
     */
    private String name;
    /**
     * @Author huxin
     * @Description 经度
     * @Date 2018/12/18 17:57
     */
    private String longitude;
    /**
     * @Author huxin
     * @Description 纬度
     * @Date 2018/12/18 20:04
     */
    private String latitude;
    /**
     * @Author huxin
     * @Description 归属地
     * @Date 2018/12/18 20:05
     */
    private String ascription;
    /**
     * @Author huxin
     * @Description 创建、修改时间
     * @Date 2018/12/18 17:54
     */
    private Date createTime;
    /**
     * @Author huxin
     * @Description 是否删除 false 删除 true 未删除
     * @Date 2018/12/18 17:55
     */
    private Boolean logicRemove;
    /**
     * @Author huxin
     * @Description 关键字
     * @Date 2018/12/18 20:23
     */
    private  String keyword;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude( String longitude ) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude( String latitude ) {
        this.latitude = latitude;
    }

    public String getAscription() {
        return ascription;
    }

    public void setAscription( String ascription ) {
        this.ascription = ascription;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}