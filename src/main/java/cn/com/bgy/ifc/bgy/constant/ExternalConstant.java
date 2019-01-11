package cn.com.bgy.ifc.bgy.constant;

import cn.com.bgy.ifc.entity.vo.common.SelectVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部平台常量
 * @date: 2018-12-11 10:06
 **/
public class ExternalConstant {

    /**
     * 集成平台操作类型
     */
    public enum OperationType {
        //新增
        ADD(1, "新增"),
        //删除
        DELETE(2, "删除"),
        //修改
        UPDATE(3, "修改");

        private Integer value;

        private String name;

        private OperationType(Integer value, String name) {
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
     * @author: ZhangCheng
     * @description:碧桂园集成平台使用状态
     * @param:
     * @return:
     */
    public enum StatusType {
        //正常
        ADD(0, "正常"),
        //禁用
        PROHIBIT(1, "禁用"),
        //删除
        DELETE(2, "删除");

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
     * 平台接口枚举
     */
    public enum PlatformValue {
        //碧桂园集成平台接口
        INTEGERATED_PLATFORM(1, "碧桂园集成平台接口"),
        //物联网设备接口
        INTERNET_THING_EQUIPMENT(2,"中联永安设备接口");

        private Integer value;

        private String name;

        private PlatformValue(Integer value, String name) {
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
            for (PlatformValue platformValue : PlatformValue.values()) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(String.valueOf(platformValue.getValue()));
                selectVo.setName(platformValue.getName());
                list.add(selectVo);
            }
            return list;
        }
    }

    /**
     * 平台内部功能接口
     * 0获取账号信息，1区域信息，2项目信息，3品牌信息，4规格信息，5设备类型，6机房信息，7设备信息
     */
    public enum MsgTypeValue {
        //集成平台获取用户信息
        BGY_ACCOUNT_OBTAIN(0, "账号信息"),
        //区域信息
        BGY_REGION_OBTAIN(1, "区域信息"),
        //项目信息
        BGY_PROJECT_OBTAIN(2, "项目信息"),
        //品牌信息
        BGY_EQUIPMENT_BRAND_OBTAIN(3, "品牌信息"),
        //规格信息
        BGY_STANDARD_OBTAIN(4, "规格信息"),
        //设备类型
        BGY_EQUIPMENT_TYPE_OBTAIN(5, "设备类型"),
        //机房信息
        BGY_MOTOR_ROOM_OBTAIN(6, "机房信息"),
        //设备信息
        GBY_EQUIPMENT_OBTAIN(7, "设备信息"),
        //集成平台获取用户权限
        BGY_PERMISSION_OBTAIN(8, "权限信息"),
        //集成平台获取机构
        BGY_ORG_OBTAIN(9, "机构信息"),
        //设备型号
        BGY_EQUIPMENT_VERSION_OBTAIN(10, "设备型号"),
        //维保公司
        BGY_REPAIR_COMPANY_OBTAIN(11, "维保公司"),
        //维保合同
        BGY_REPAIR_CONTRACT_OBTAIN(12, "维保合同"),
        //苑区
        BGY_COURT_OBTAIN(13, "苑区"),
        //街道street
        BGY_STREET_OBTAIN(14, "街道"),
        //楼栋单元building
        BGY_BUILDING_OBTAIN(15, "楼栋单元"),
        //维保工单
        BGY_WORK_ORDER_OBTAIN(16, "维保工单"),
        //消防培训
        BGY_FIRE_TRAIN_OBTAIN(17, "消防培训"),
        //消防演练
        BGY_FIRE_DRILL_OBTAIN(18, "消防演练");

        private Integer value;
        private String name;

        private MsgTypeValue(Integer value, String name) {
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
            for (MsgTypeValue msgTypeValue : MsgTypeValue.values()) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(String.valueOf(msgTypeValue.getValue()));
                selectVo.setName(msgTypeValue.getName());
                list.add(selectVo);
            }
            return list;
        }
    }

}
