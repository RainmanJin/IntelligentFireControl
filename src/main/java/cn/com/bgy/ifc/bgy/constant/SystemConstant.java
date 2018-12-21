package cn.com.bgy.ifc.bgy.constant;

import cn.com.bgy.ifc.entity.vo.basic.SelectVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统常量
 * @date: 2018-12-05 10:23
 **/
public class SystemConstant {

    /**
     * 用户类型(0一般用户,1机构管理员,2系统管理员,3技术管理员)
     */
    public enum UserType {
        //一般用户
        GENERAL_USER(0, "一般用户"),
        //机构管理员
        ORG_ADMIN(1, "机构管理员"),
        //系统管理员
        SYSTEM_ADMIN(2, "系统管理员"),
        //技术管理员
        ECHNOLOGY_ADMIN(3, "技术管理员");

        private Integer value;

        private String name;

        private UserType(Integer value, String name) {
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

    /**
     * @Author huxin
     * @Description 系统角色类型
     * @Date 2018/12/17 18:18
     */
    public enum SystemRoleType {
        //普通用户
        USER_ROLR(0, "普通用户"),
        //集团管理员
        GROUP_ADMIN_ROLE(1, "集团管理员"),
        //集团用户
        GROUP_UERR_ROLE(2, "集团用户"),
        //区域管理员
        REGION_ADMIN_ROLE(3, "区域管理员"),
        //区域用户
        REGION_USER_ROLE(4, "区域管理员"),
        //项目管理员
        POJECT_ADMIN_ROLE(5, "项目管理员"),
        //项目用户
        POJECT_ADMIN_USER(6, "项目用户");
        private Integer value;
        private String name;

        private SystemRoleType(Integer value, String name) {
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
            SelectVo selectVo = new SelectVo();
            for (SystemRoleType systemRoleType : SystemRoleType.values()) {
                selectVo.setValue(String.valueOf(systemRoleType.getValue()));
                selectVo.setName(systemRoleType.getName());
                list.add(selectVo);
            }
            return list;
        }

    }


}
