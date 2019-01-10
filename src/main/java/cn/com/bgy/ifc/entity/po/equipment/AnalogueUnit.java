package cn.com.bgy.ifc.entity.po.equipment;

public class AnalogueUnit {
    /**
     * 
     */
    private Long id;

    /**
     * 模拟量单位名称
     */
    private String name;

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
     * 模拟量单位名称
     * @return name 模拟量单位名称
     */
    public String getName() {
        return name;
    }

    /**
     * 模拟量单位名称
     * @param name 模拟量单位名称
     */
    public void setName(String name) {
        this.name = name;
    }
}