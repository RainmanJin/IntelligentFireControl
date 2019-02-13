package cn.com.bgy.ifc.bgy.constant;

/**
 * @author: ZhangCheng
 * @description:系统巡检体检
 * @date: 2019-02-13 19:10
 **/
public enum SystemCheckingConstant {

    //系统巡检
    SYSTEM_INSPECTION(1,"系统巡检"),
    //系统体检
    SYSTEM_EXAMINATION(2,"系统体检"),
    //一键体检
    ONE_KEY_EXAMINATION(1,"一键体检"),
    //自动体检
    AUTOMATIC_EXAMINATION(2,"自动体检"),
    //一键巡检
    ONE_KEY_INSPECTION(1,"一键巡检"),
    //自动巡检
    AUTOMATIC_INSPECTION(2,"自动巡检");

    private Integer value;
    private String name;

    private SystemCheckingConstant(Integer value, String name) {
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
