package cn.com.bgy.ifc.entity.vo.equipment;

import cn.com.bgy.ifc.entity.vo.common.BgyBaseVo;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台设备品牌VO
 * @date: 2018-12-21 15:13
 **/
public class BgyEquipmentBrandVo extends BgyBaseVo {
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
    private Integer status;

    /**
     * 品牌描述
     */
    private String description;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
