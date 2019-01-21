package cn.com.bgy.ifc.entity.po.equipment;

public class EquipmentBrand {
    //ID
    private Long id;
    //设备品牌名
    private String name;
    //设备品牌状态 0为正常,1为禁用,2为删除
    private Integer status;
    //描述
    private String description;

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