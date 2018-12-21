package cn.com.bgy.ifc.entity.vo.equipment;

import cn.com.bgy.ifc.entity.vo.projects.BgyBaseVo;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台设备类型VO
 * @date: 2018-12-21 11:57
 **/
public class BgyEquipmentTypeVo extends BgyBaseVo {
    /**
     * 设备类型名
     */
    private String name;
    /**
     * 父级ID
     */
    private Long parentId;
    /**
     * 设备状态
     */
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
