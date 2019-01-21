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

    /**
     * 系统菜单模块类型
     */
    public enum SystemMenuType{
        //首页
        INDEX_MENU(1, "首页"),
        //系统管理
        SYSTEM_MENU(2, "系统管理"),
        //设备管理及监测equipment
        EQUIPMENT_MENU(3, "设备管理及监测"),
        //维保管理Maintenance
        MAINTENANCE_MENU(4, "维保管理"),
        //召修管理repair
        REPAIR_MENU(5, "召修管理"),
        //报表管理Report form
        REPORT_FORM_MENU(6, "报表管理"),
        //消防巡查监管Fire patrol
        FIRE_PATROL_MENU(7, "消防巡查监管");

        private Integer value;
        private String name;

        private SystemMenuType(Integer value, String name) {
            this.value = value;
            this.name = name;
        }

        public Integer getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public static List<SelectVo> getSelectList() {
            List<SelectVo> list = new ArrayList<>();
            for (SystemMenuType systemMenuType : SystemMenuType.values()) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(String.valueOf(systemMenuType.getValue()));
                selectVo.setName(systemMenuType.getName());
                list.add(selectVo);
            }
            return list;
        }
    }

    /**
     * 培训演练任务周期
     */
    public enum FirePlanCycle{
        //每日
        EVERYDAY(1, "每日"),
        //每周
        WEEKLY(2, "每周"),
        //月度
        MONTHLY(3, "月度"),
        //季度
        QUARTER(4, "季度"),
        //半年
        HALF_YEAR(5, "半年"),
        //年度
        YEAR(6, "年度");

        private Integer value;
        private String name;

        private FirePlanCycle(Integer value, String name) {
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
     * 培训演练工作状态
     */
    public enum CompleteType{
        //未处理
        UNTREATED(1, "未处理"),
        //处理中
        IN_PROCESS(2, "处理中"),
        //已完成
        COMPLETED(3, "已完成");

        private Integer value;
        private String name;

        private CompleteType(Integer value, String name) {
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
