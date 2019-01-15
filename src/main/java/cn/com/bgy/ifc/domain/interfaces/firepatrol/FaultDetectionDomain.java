package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;

/**
 * @Author huxin
 * @Date 2019/1/12 18:20
 * @Description 设施设备故障检测
 **/

public interface FaultDetectionDomain {
    //添加设施故障检测
    int addFaultDetection( RecordTable recordTable, String recordContent );
    //修改设施故障检测
    int editFaultDetection( RecordTable recordTable, String recordContent );
}
