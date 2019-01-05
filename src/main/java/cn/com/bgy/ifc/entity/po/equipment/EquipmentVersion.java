package cn.com.bgy.ifc.entity.po.equipment;
/**
 * @Author huxin
 * @Description 设备型号
 * @Date 2018/12/21 16:16
 */
public class EquipmentVersion {
    //型号id
    private Long id;
    //关联品牌ID
    private Long brandId;
    //型号名
    private String name;
    //状态 1正常  0禁用
    private Integer status;
    //型号描述
    private String description;
    //是否删除  0存在   1删除
    private Boolean logicRemove;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getLogicRemove() {
        return logicRemove;
    }

    public void setLogicRemove(Boolean logicRemove) {
        this.logicRemove = logicRemove;
    }
}