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

    /**
     * 模拟量记录类型
     */
    public enum analogQuantityType{
        //模拟量记录类型：默认:10000
        DEFAULT_TYPE(10000, "默认:10000"),
        //模拟量记录类型：市政消火栓:10001
        FIRST_MUNICIPAL_TYPE(10001, "市政消火栓:10001"),
        //模拟量记录类型：市政消火栓:10002
        SECOND_MUNICIPAL_TYPE(10002, "市政消火栓:10002"),
        //模拟量记录类型：市政消火栓:10003
        THIRD_MUNICIPAL_TYPE(10003, "市政消火栓:10003"),
        //模拟量记录类型：市政消火栓:10004
        FOURTH_MUNICIPAL_TYPE(10004, "市政消火栓:10004"),
        //模拟量记录类型：市政消火栓:10005
        FIFTH_MUNICIPAL_TYPE(10005, "市政消火栓:10005");

        private Integer value;
        private String name;

        private analogQuantityType(Integer value, String name) {
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
