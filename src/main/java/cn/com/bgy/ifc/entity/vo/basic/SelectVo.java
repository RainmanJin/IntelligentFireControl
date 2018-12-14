package cn.com.bgy.ifc.entity.vo.basic;

/**
 * @author: ZhangCheng
 * @description:下拉选择列表实体
 * @date: 2018-12-14 09:14
 **/
public class SelectVo {
    /**
     * 属性值
     */
    private String value;

    /**
     * 属性名称
     */
    private String name;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SelectVo{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
