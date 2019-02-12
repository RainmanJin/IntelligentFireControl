package cn.com.bgy.ifc.controller.inner.report;

import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.report.EquipmentReportService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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
public class AlarmReportController {

    @Autowired
    private EquipmentReportService equipmentReportService;
    /*
     * @Author  huxin
     * @Description 图表数据       
     * @param   [regionId, projectId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/2/11 10:51
     */
    @GetMapping("chartData")
    public ResponseVO<Object> getEquipmentReportChart(Long regionId,Long projectId){
        Map<String, Object> map = equipmentReportService.getEquipmentReportChart(regionId,projectId);
        return ResponseVO.<Object>success().setData(map);
    }
    /*
     * @Author  huxin
     * @Description 统计数据
     * @param   [regionId, projectId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @Date 2019/2/11 11:09
     */
    @GetMapping("statisticsData")
    public ResponseVO<Object> getEquipmentReportStatistics(Long regionId,Long projectId){
        Map<String, Object> map = equipmentReportService.getEquipmentReportStatistics(regionId,projectId);
        return ResponseVO.<Object>success().setData(map);
    }
    /*
     * @Author  huxin
     * @Description 列表数据
     * @param   [page, regionId, projectId]
     * @retrue  cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo>
     * @Date 2019/2/11 10:51
     */
    @GetMapping("pageData")
    public ResponseVO<PageInfo> getEquipmentReportList( Page<Object> page, Long regionId, Long projectId){
        PageInfo pageInfo= equipmentReportService.getEquipmentReportList(page,regionId,projectId);
        return ResponseVO.<PageInfo>success().setData(pageInfo);
    }
}
