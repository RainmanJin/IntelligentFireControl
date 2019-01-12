package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;

/**
 * @Author huxin
 * @Date 2019/1/12 18:20
 * @Description
 **/

public interface FaultDetectionDomain {
    int addFaultDetection( RecordTable recordTable, String recordContent );
}
