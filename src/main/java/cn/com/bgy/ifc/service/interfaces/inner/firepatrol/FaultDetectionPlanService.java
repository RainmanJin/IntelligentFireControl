package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.FaultDetectionPlan;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/14 11:16
 * @Description 消防设施设备故障检测计划
 **/

public interface FaultDetectionPlanService {
    //添加消防设施设备故障检测计划
    int addFaultDetection( FaultDetectionPlan faultDetectionPlan ,Long equipmentId,Long recordContentId);
    //修改消防设施设备故障检测计划
    int editFaultDetectionPlan( FaultDetectionPlan faultDetectionPlan );
    //删除消防设施设备故障检测计划（含批量）
    int deleteFaultDetectionPlan( String ids );
    //查询消防设施设备故障检测计划列表
    PageInfo listFaultDetectionPlan( Page<Object> page, String keyword, FaultDetectionPlan faultDetectionPlan );
    //根据ID查询消防设施设备故障检测计划列表
    Map<String,Object> getFaultDetectionPlanByID( Long id );
}
