package cn.com.bgy.ifc.bgy.constant;

/**
 * @author: ZhangCheng
 * @description:系统日志类型常量
 * @date: 2018-12-05 10:23
 **/
public enum SystemLogType {

    //登录日志，操作日志，错误日志，接口日志，系统日志
    //操作日志
    OPERATION_LOG(1, "操作日志"),
    //登录日志
    LOGON_LOG(2, "登录日志"),
    //错误日志
    ERROR_LOG(3, "错误日志"),
    //系统日志
    SYSTEM_LOG(4, "系统日志"),
    //接口日志
    INTERFACE_LOG(5, "接口日志");

    private Integer value;
    private String name;

    private SystemLogType(Integer value, String name) {
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
