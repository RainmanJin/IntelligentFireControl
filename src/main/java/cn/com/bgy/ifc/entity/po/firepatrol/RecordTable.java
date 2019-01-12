package cn.com.bgy.ifc.entity.po.firepatrol;

import java.util.Date;

public class RecordTable {
    /**
     * ID
     */
    private Long id;

    /**
     * 记录内容
     */
    private String recordContent;

    /**
     * 设备类别ID
     */
    private Long equipmentTypeId;

    /**
     * 是否逻辑删除  0:存在  1：删除
     */
    private Boolean logicRemove;

    /**
     * 创建、修改时间
     */
    private Date createTime;

    /**
     * ID
     * @return id ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 记录内容
     * @return record_content 记录内容
     */
    public String getRecordContent() {
        return recordContent;
    }

    /**
     * 记录内容
     * @param recordContent 记录内容
     */
    public void setRecordContent(String recordContent) {
        this.recordContent = recordContent;
    }

    /**
     * 设备类别ID
     * @return equipment_type_id 设备类别ID
     */
    public Long getEquipmentTypeId() {
        return equipmentTypeId;
    }

    /**
     * 设备类别ID
     * @param equipmentTypeId 设备类别ID
     */
    public void setEquipmentTypeId(Long equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    /**
     * 是否逻辑删除  0:存在  1：删除
     * @return logic_remove 是否逻辑删除  0:存在  1：删除
     */
    public Boolean getLogicRemove() {
        return logicRemove;
    }

    /**
     * 是否逻辑删除  0:存在  1：删除
     * @param logicRemove 是否逻辑删除  0:存在  1：删除
     */
    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }

    /**
     * 创建、修改时间
     * @return create_time 创建、修改时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建、修改时间
     * @param createTime 创建、修改时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}