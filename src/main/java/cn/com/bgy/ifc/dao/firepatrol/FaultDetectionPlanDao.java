package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FaultDetectionPlan;

import java.util.List;
import java.util.Map;

public interface FaultDetectionPlanDao extends BaseDao<FaultDetectionPlan> {
    //查询消防设施设备故障检测计划列表
    List<Map<String,Object>> listFaultDetectionPlan( Map<String,Object> map );
}