package cn.com.bgy.ifc.bgy.constant;

/**
 * @author: ZhangCheng
 * @description:系统登录状态
 * @date: 2018-01-05 10:23
 **/
public enum LoginState {

    //未登录
    NOT_LOGIN(0,"未登录"),
    //已登录
    IS_LOGIN(1,"已登录");
    private Integer value;
    private String name;

    private LoginState(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
