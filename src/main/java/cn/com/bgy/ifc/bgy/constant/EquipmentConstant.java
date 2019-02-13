package cn.com.bgy.ifc.bgy.constant;

/**
 * @author: ZhangCheng
 * @description:设备常量类
 * @date: 2019-01-09 11:22
 **/
public class EquipmentConstant {

    /**
     * 运行状态（设备状态 0 停用 1 正常 2报废）
     */
    public enum RunState {
        //停用
        BLOCK_UP(0,"停用"),
        //正常
        NORMAL(1,"正常"),
        //报废
        SCRAP(2,"报废");
        private Integer value;
        private String name;

        private RunState(Integer value, String name) {
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
     * 设备状态
     */
    public enum StateEnum {
        //正常
        NORMAL(1, "正常"),
        //故障
        FAULT(2, "故障"),
        //预警
        EARLY_WARNING(3, "预警"),
        //报警
        CALL_POLICE(4, "告警");

        private Integer value;
        private String name;

        private StateEnum(Integer value, String name) {
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
     * 实时告警状态
     * 火警:1 告警:2 隐患:3
     */
    public enum AlarmEnum {
        //火警
        FIRE_ALARM(1, "火警"),
        //告警
        GIVE_ALARM(2, "告警"),
        //隐患
        HIDDEN_DANGER(3, "隐患");

        private Integer value;
        private String name;

        private AlarmEnum(Integer value, String name) {
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
    public enum AnalogQuantityType {
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

        private AnalogQuantityType(Integer value, String name) {
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
     * 模拟量异常类型
     */
    public enum AnalogAbnormalType {
        //正常
        NORMAL(0, "正常"),
        //高报警门限
        ALARM_THRESHOLD_MAX(1, "高报警门限"),
        //低报警门限
        ALARM_THRESHOLD_MIN(2, "低报警门限"),
        //高故障门限
        FAULT_THRESHOLD_MAX(3, "高故障门限"),
        //低故障门限
        FAULT_THRESHOLD_MIN(4, "低故障门限");

        private Integer value;
        private String name;

        private AnalogAbnormalType(Integer value, String name) {
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
     * 状态记录类型
     */
    public enum StatusRecordType {
        //默认状态
        DEFAULT_STATE(0, "默认状态"),
        //市政消火栓-盖帽状态
        BLOCK_STATE(1, "市政消火栓-盖帽状态"),
        //市政消火栓-倾斜状态
        TILTING_STATE(2, "市政消火栓-倾斜状态"),
        //市政消火栓-震动状态
        VIBRATION_STATE(3, "市政消火栓-震动状态"),
        //市政消火栓-阀门微动状态
        VALVE_FRETTING_STATE(4, "市政消火栓-阀门微动状态"),
        //网络连接超时
        CON_TIMED_OUT(5, "网络连接超时");

        private Integer value;
        private String name;

        private StatusRecordType(Integer value, String name) {
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
     * 事件类型
     */
    public enum EventType {
        //正常
        NORMAL(1, "正常"),
        //故障
        FAULT(2, "故障"),
        //预警
        EARLY_WARNING(3, "预警"),
        //报警
        CALL_POLICE(4, "告警");

        private Integer value;
        private String name;

        private EventType(Integer value, String name) {
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
     * 事件状态
     */
    public enum EventState {
        //未处理
        NORMAL(0, "未处理"),
        //已处理
        FAULT(1, "已处理");

        private Integer value;
        private String name;

        private EventState(Integer value, String name) {
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
     * 告警方式类型
     */
    public enum AlarmModeType {
        //短信通知
        SMS_NOTICE(1, "短信通知"),
        //语音电话
        VOICE_CALL(2, "语音电话"),
        //APP通知
        APP_NOTICE(3, "APP通知");

        private Integer value;
        private String name;

        private AlarmModeType(Integer value, String name) {
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
