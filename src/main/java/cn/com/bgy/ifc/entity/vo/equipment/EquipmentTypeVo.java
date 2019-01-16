package cn.com.bgy.ifc.entity.vo.equipment;

import javax.validation.constraints.NotBlank;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-15 10:49
 **/
public class EquipmentTypeVo {

    /**
     * 系统自增Id
     */
    private Long id;

    /**
     * 设备类别名称
     */
    @NotBlank(message="设备类别名称不能为空！")
    private String name;

    /**
     * 物联网设备编码
     */
    private Integer thingCode;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 状态(0:无效;1:有效)
     */
    private Integer status;
    /**
     * 逻辑删除
     */
    private Boolean logicRemove;
    /**
     * 关键字
     */
    private String keyword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getThingCode() {
        return thingCode;
    }

    public void setThingCode(Integer thingCode) {
        this.thingCode = thingCode;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
