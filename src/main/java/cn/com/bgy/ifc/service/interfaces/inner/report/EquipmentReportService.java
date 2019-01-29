package cn.com.bgy.ifc.service.interfaces.inner.report;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/29 11:13
 * @Description 设备报表统计
 **/

public interface EquipmentReportService {
    //获取设备统计图表
    Map<String, Object> getEquipmentReportChart( Long regionId, Long projectId );
    //获取设备统计列表
    void getEquipmentReportList( Long regionId, Long projectId );
}
