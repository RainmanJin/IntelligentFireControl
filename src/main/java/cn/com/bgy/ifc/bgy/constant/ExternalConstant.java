package cn.com.bgy.ifc.bgy.constant;

/**
 * @author: ZhangCheng
 * @description:外部平台常量
 * @date: 2018-12-11 10:06
 **/
public class ExternalConstant {

    /*
     * 集成平台操作类型
     * */
    public enum OperationType{
        //新增
        ADD(1),
        //删除
        DELETE(2),
        //修改
        UPDATE(3);

        private Integer value;

        private OperationType(Integer value) {
            this.value = value;
        }
        public Integer getValue(){
            return value;
        }
    }

    /*
     * 平台接口枚举
     * */
    public enum PlatformValue{
        //碧桂园集成平台接口
        INTEGERATED_PLATFORM(1);

        private Integer value;

        private PlatformValue(Integer value) {
            this.value = value;
        }
        public Integer getValue(){
            return value;
        }
    }

    /*
     * 平台内部功能接口
     * 0获取账号信息，1区域信息，2项目信息，3品牌，4规格信息，5设备类型，6机房信息，7设备信息
     * */
    public enum MsgTypeValue{
        //集成平台获取用户数据（增量）
        BGY_ACCOUNT_INCREMENT(1);

        private Integer value;

        private MsgTypeValue(Integer value) {
            this.value = value;
        }
        public Integer getValue(){
            return value;
        }
    }
}
