package cn.com.bgy.ifc.entity.po.equipment;

public class EquipmentThingType {
    /**
     * 
     */
    private Long id;

    /**
     * 消防设备值
     */
    private Integer value;

    /**
     * 消防设备名称
     */
    private String name;

    /**
     * 系统类型：1，消防部件：2
     */
    private Integer type;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 消防设备值
     * @return value 消防设备值
     */
    public Integer getValue() {
        return value;
    }

    /**
     * 消防设备值
     * @param value 消防设备值
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 消防设备名称
     * @return name 消防设备名称
     */
    public String getName() {
        return name;
    }

    /**
     * 消防设备名称
     * @param name 消防设备名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 系统类型：1，消防部件：2
     * @return type 系统类型：1，消防部件：2
     */
    public Integer getType() {
        return type;
    }

    /**
     * 系统类型：1，消防部件：2
     * @param type 系统类型：1，消防部件：2
     */
    public void setType(Integer type) {
        this.type = type;
    }
}