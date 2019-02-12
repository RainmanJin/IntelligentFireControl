package cn.com.bgy.ifc.entity.po.firepatrol;

import java.math.BigDecimal;

public class FundsDudget {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 区域ID
     */
    private Long regionId;

    /**
     * 项目ID
     */
    private Long projectId;

    /**
     * 年份
     */
    private Integer year;

    /**
     * 经费
     */
    private BigDecimal funds;
    //是否逻辑删除    0:存在    1:删除
    private Boolean logicRemove;

    /**
     * 描述
     */
    private String description;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
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
     * 年份
     * @return year 年份
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 年份
     * @param year 年份
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * 经费
     * @return funds 经费
     */
    public BigDecimal getFunds() {
        return funds;
    }

    /**
     * 经费
     * @param funds 经费
     */
    public void setFunds(BigDecimal funds) {
        this.funds = funds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }
}