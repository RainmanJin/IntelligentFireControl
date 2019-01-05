/*
*
* EquipmentType.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-13
*/
package cn.com.bgy.ifc.entity.po.equipment;

import java.io.Serializable;

public class EquipmentType implements Serializable {
    /**
     * 系统自增Id
     */
    private Long id;

    /**
     * 设备类别名称
     */
    private String name;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 状态(0:无效;1:有效)
     */
    private Integer status;
    //逻辑删除
    private Boolean logicRemove;
    /**
     * equipment_type
     */
    private static final long serialVersionUID = 1L;

    /**
     * 系统自增Id
     * @return id 系统自增Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 系统自增Id
     * @param id 系统自增Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设备类别名称
     * @return name 设备类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设备类别名称
     * @param name 设备类别名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 父级ID
     * @return parent_id 父级ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 父级ID
     * @param parentId 父级ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 状态(0:无效;1:有效)
     * @return status 状态(0:无效;1:有效)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态(0:无效;1:有效)
     * @param status 状态(0:无效;1:有效)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove( Boolean logicRemove ) {
        this.logicRemove = logicRemove;
    }
}