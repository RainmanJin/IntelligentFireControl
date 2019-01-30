package cn.com.bgy.ifc.service.interfaces.inner.report;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

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
    PageInfo getEquipmentReportList( Page<Object> page, Long regionId, Long projectId );
}
