package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.FaultDetectionPlan;

import java.util.List;

/**
 * @Author huxin
 * @Date 2019/1/16 9:36
 * @Description 消防设施设备故障检测计划
 **/

public interface FaultDetectionPlanDomain {
    //添加设施设备故障检测计划
    int addFaultDetection( FaultDetectionPlan faultDetectionPlan,Long equipmentId,Long recordContentId);
    //删除设施设备故障检测
    int deleteFaultDetectionPlan( List<Long> list );
}
