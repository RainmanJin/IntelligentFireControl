package cn.com.bgy.ifc.entity.vo.equipment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-16 16:14
 **/
public class EquipmentListenersVo {

    private Long id;

    /**
     * 监听名称
     */
    @Size(max=50,message="监听名称长度不能超过50字符！")
    private String name;

    /**
     * 监听地址
     */
    @NotBlank(message="监听地址不能为空！")
    @Size(max=100,message="监听地址长度不能超过100字符！")
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
