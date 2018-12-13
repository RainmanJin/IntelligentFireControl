package cn.com.bgy.ifc.entity.vo.projects;

/**
 * 品牌获取实体Vo
 */
public class BgyBrandVo extends BgyBaseVo {
    /**
     * 品牌id
     */
    private Long id;

    /**
     * 品牌名称
     */
    private String name;

    /**
     * 状态,0为正常,1为禁用,2为删除
     */
    private Long status;

    /**
     * 品牌描述
     */
    private String description;

    /**
     * brand
     */
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     * @return id 品牌id
     */
    public Long getId() {
        return id;
    }

    /**
     * 品牌id
     * @param id 品牌id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 品牌名称
     * @return name 品牌名称
     */
    public String getName() {
        return name;
    }

    /**
     * 品牌名称
     * @param name 品牌名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 状态,0为正常,1为禁用,2为删除
     * @return status 状态,0为正常,1为禁用,2为删除
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 状态,0为正常,1为禁用,2为删除
     * @param status 状态,0为正常,1为禁用,2为删除
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * 品牌描述
     * @return description 品牌描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 品牌描述
     * @param description 品牌描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}
