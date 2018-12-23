package cn.com.bgy.ifc.entity.vo.equipment;

import cn.com.bgy.ifc.entity.vo.project.BgyBaseVo;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台设备型号VO
 * @date: 2018-12-12 15:20
 **/
public class BgyEquipmentVersionVo extends BgyBaseVo {

    /**
     * 关联品牌id
     */
    private Long brandId;

    /**
     * 型号名称
     */
    private String name;

    /**
     * 状态,1-正常,0-禁用
     */
    private Integer status;

    /**
     * 型号描述
     */
    private String description;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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
