package cn.com.bgy.ifc.controller.inner.report;

import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.report.EquipmentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/1/29 10:43
 * @Description 设备报表统计
 **/
@RestController
@RequestMapping("/report/equipment")
public class EquipmentReportController {

    @Autowired
    private EquipmentReportService equipmentReportService;
    @GetMapping("chartData")
    public ResponseVO<Object> getEquipmentReportChart(Long regionId,Long projectId){
        Map<String, Object> map = equipmentReportService.getEquipmentReportChart(regionId,projectId);
        return ResponseVO.<Object>success().setData(map);
    }
    @GetMapping("pageData")
    public ResponseVO<Object> getEquipmentReportList(Long regionId,Long projectId){
        equipmentReportService.getEquipmentReportList(regionId,projectId);
        return null;
    }
}
