package cn.com.bgy.ifc.entity.po.equipment;

public class EquipmentListeners {

    private Long id;

    /**
     * 监听事件名称
     */
    private String name;

    /**
     * 监听地址
     */
    private String url;

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
     * 监听事件名称
     * @return name 监听事件名称
     */
    public String getName() {
        return name;
    }

    /**
     * 监听事件名称
     * @param name 监听事件名称
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}