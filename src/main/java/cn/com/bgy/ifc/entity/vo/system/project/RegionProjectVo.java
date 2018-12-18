package cn.com.bgy.ifc.entity.vo.system.project;

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
     * @Description 经纬度
     * @Date 2018/12/18 17:57
     */
    private String locationStr;
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
     * @Date 2018/12/18 18:14
     */
    private String keyword;
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

    public String getLocationStr() {
        return locationStr;
    }

    public void setLocationStr( String locationStr ) {
        this.locationStr = locationStr;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword( String keyword ) {
        this.keyword = keyword;
    }
}