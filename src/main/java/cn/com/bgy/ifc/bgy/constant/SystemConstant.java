package cn.com.bgy.ifc.bgy.constant;

/**
 * @author: ZhangCheng
 * @description:系统常量
 * @date: 2018-12-05 10:23
 **/
public class SystemConstant {

    /*
    * 启用状态
    * */
    public enum EnableState {
        //禁用
        PROHIBIT(0),
        //启用
        ENABLE(1),
        //锁定
        LOCKING(2),
        //删除
        DELETE(3);

        private Integer value;

        private EnableState(Integer value) {
            this.value = value;
        }
        public Integer getValue(){
            return value;
        }
    }

    /*
     * 系统日志类型
     * */
    public enum SystemLogType {
        //操作日志
        OPERATION_LOG(1),
        //设备日志
        DEVICE_LOG(2),
        //消防监测日志
        FIRE_MONITOR_LOG(3),
        //告警日志
        GIVE_ALARM_LOG(4),
        //召修日志
        CALL_REPAIR_LOG(5),
        //维保日志
        MAINTENANCE_LOG(6),
        //接口调用日志
        INTERFACE_LOG(7);

        private Integer value;

        private SystemLogType(Integer value) {
            this.value = value;
        }
        public Integer getValue(){
            return value;
        }
    }

}
