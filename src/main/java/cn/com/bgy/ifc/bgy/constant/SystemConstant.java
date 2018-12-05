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
        ENABLE(1);

        private Integer value;

        private EnableState(Integer value) {
            this.value = value;
        }
        public Integer getValue(){
            return value;
        }
    }
}
