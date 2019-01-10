package cn.com.bgy.ifc.bgy.constant;

/**
 * @author: ZhangCheng
 * @description:设备常量类
 * @date: 2019-01-09 11:22
 **/
public class EquipmentConstant {
    /**
     * 设备状态
     */
    public enum stateEnum{
        //正常
        NORMAL(1, "正常"),
        //故障
        FAULT(2, "故障"),
        //预警
        EARLY_WARNING(3, "预警"),
        //报警
        CALL_POLICE(4, "报警");

        private Integer value;
        private String name;

        private stateEnum(Integer value, String name) {
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
}
