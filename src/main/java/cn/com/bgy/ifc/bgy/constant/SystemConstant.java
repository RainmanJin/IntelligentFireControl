package cn.com.bgy.ifc.bgy.constant;

import cn.com.bgy.ifc.entity.vo.common.SelectVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统常量
 * @date: 2018-12-05 10:23
 **/
public class SystemConstant {

    /**
     * 用户角色
     */
    public   static  final String SYSTEM_ROLES_ADMIN="admin";
    public   static  final String SYSTEM_ROLES_ORG_ADMIN="orgAdmin";
    public   static  final String SYSTEM_ROLES_ORG_USER="orgUser";
    public   static  final String SYSTEM_ROLES_AREA_ADMIN="areaAdmin";
    public   static  final String SYSTEM_ROLES_AREA_USRE="areaUser";
    public   static  final String SYSTEM_ROLES_PROJECT_ADMIN="projectAdmin";
    public   static  final String SYSTEM_ROLES_PROJECT_USER="projectUser";
    /**
     * 初始化密码
     */
    public   static  final  String INITAL_PASSWORD="123456";

    /**
     * @author chenlie
     * 用户角色
     */
    public enum SystemRoles {
        /**
         * 系统管理员
         */
        ADMIN("admin", "系统管理员"),
        /**
         * 集团管理员
         */
        ORG_ADMIN("orgAdmin", "集团管理员"),
        /**
         * 集团用户
         */
        ORG_USER("orgUser", "集团用户"),
        /**
         * 区域管理员
         */
        AREA_ADMIN("areaAdmin", "区域管理员"),
        /**
         * 区域用户
         */
        AREA_USRE("areaUser", "区域用户"),
        /**
         * 项目管理员
         */
        PROJECT_ADMIN("projectAdmin", "项目管理员"),
        /**
         * 项目用户
         */
        PROJECT_USER("projectUser", "项目用户");

        private String value;

        private String name;

        private SystemRoles(String  value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public static List<SelectVo> getSelectList() {
            List<SelectVo> list = new ArrayList<>();
            for (SystemRoles systemRoles : SystemRoles.values()) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(String.valueOf(systemRoles.getValue()));
                selectVo.setName(systemRoles.getName());
                list.add(selectVo);
            }
            return list;
        }
    }

    /*
     * 启用状态
     * */
    public enum EnableState {
        //禁用
        PROHIBIT(0, "禁用"),
        //启用
        ENABLE(1, "启用"),
        //锁定
        LOCKING(2, "锁定"),
        //删除
        DELETE(3, "删除");

        private Integer value;
        private String name;

        private EnableState(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        /**
         * @author: ZhangCheng
         * @description:枚举中的属性转换为下拉列表List
         * @param: []
         * @return: java.util.List<cn.com.bgy.ifc.entity.vo.basic.SelectVo>
         */
        public static List<SelectVo> getSelectList() {
            List<SelectVo> list = new ArrayList<>();
            for (EnableState enableState : EnableState.values()) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(String.valueOf(enableState.getValue()));
                selectVo.setName(enableState.getName());
                list.add(selectVo);
            }
            return list;
        }
    }

    public enum StatusType {
        //无效
        INVALID(0, "无效"),
        //有效
        EFFECTIVE(1, "有效");

        private Integer value;
        private String name;

        private StatusType(Integer value, String name) {
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

    /*
     * 系统日志类型
     * */
    public enum SystemLogType {
        //操作日志
        OPERATION_LOG(1, "操作日志"),
        //设备日志
        DEVICE_LOG(2, "设备日志"),
        //消防监测日志
        FIRE_MONITOR_LOG(3, "消防监测日志"),
        //告警日志
        GIVE_ALARM_LOG(4, "告警日志"),
        //召修日志
        CALL_REPAIR_LOG(5, "召修日志"),
        //维保日志
        MAINTENANCE_LOG(6, "维保日志"),
        //接口调用日志
        INTERFACE_LOG(7, "接口调用日志");

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

        /**
         * @author: ZhangCheng
         * @description:枚举中的属性转换为下拉列表List
         * @param: []
         * @return: java.util.List<cn.com.bgy.ifc.entity.vo.basic.SelectVo>
         */
        public static List<SelectVo> getSelectList() {
            List<SelectVo> list = new ArrayList<>();
            for (SystemLogType systemLogType : SystemLogType.values()) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(String.valueOf(systemLogType.getValue()));
                selectVo.setName(systemLogType.getName());
                list.add(selectVo);
            }
            return list;
        }
    }

}
