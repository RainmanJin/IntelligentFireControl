/*
*
* systemModel.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-15
*/
package cn.com.bgy.ifc.entity.po.system;

import java.io.Serializable;

public class SystemModel implements Serializable {
    /**
     * 主键Id
     */
    private Long id;

    /**
     * 模块名称
     */
    private String modelName;

    /**
     * 
     */
    private String iconName;

    /**
     * 
     */
    private String urlValue;

    /**
     * system_model
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     * @return id 主键Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键Id
     * @param id 主键Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 模块名称
     * @return model_name 模块名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 模块名称
     * @param modelName 模块名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    /**
     * 
     * @return icon_name 
     */
    public String getIconName() {
        return iconName;
    }

    /**
     * 
     * @param iconName 
     */
    public void setIconName(String iconName) {
        this.iconName = iconName == null ? null : iconName.trim();
    }

    /**
     * 
     * @return url_value 
     */
    public String getUrlValue() {
        return urlValue;
    }

    /**
     * 
     * @param urlValue 
     */
    public void setUrlValue(String urlValue) {
        this.urlValue = urlValue == null ? null : urlValue.trim();
    }
}