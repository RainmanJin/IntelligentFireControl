package cn.com.bgy.ifc.controller.inner.report;

import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.report.AlarmReportService;
import cn.com.bgy.ifc.service.interfaces.inner.report.EquipmentReportService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @param:告警报表统计
 * @return:
 * @auther: chenlie
 * @date: 2019/2/13 9:54
 */
@RestController
@RequestMapping("/report/alarm")
public class ReportAlarmController {


    @Autowired
    private AlarmReportService alarmReportService;
    /**
     * @description:报表管理，告警报表
     * @param: [map]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/2/13 9:44
     */
    @GetMapping("chartData")
    public ResponseVO<Object> getEquipmentReportChart(Map<String,Object> map){
        //告警分项统计
        Map<String, Object> itemMap = alarmReportService.getAlarmByItem(map);
        ////各区域告警数量排名
        Map<String, Object> regionRank = alarmReportService.getAlarmByRegionRank(map);
        //告警分系统统计
        Map<String, Object> system = alarmReportService.getAlarmBySystem(map);
        //告警总数和火警总数
        Map<String, Object> count1 = alarmReportService.getAlarmCount(map);
        //告警总数和火警总数
        Map<String, Object> count2 = alarmReportService.getAlarmCount(map);
        //环比
        Map<String, Object> countChainRatio1 = alarmReportService.getAlarmCountChainRatio(map);
        //环比
        Map<String, Object> countChainRatio2 = alarmReportService.getAlarmCountChainRatio(map);
        //同比
        Map<String, Object> countYearOnYear1 = alarmReportService.getAlarmCountYearOnYear(map);
        //同比
        Map<String, Object> countYearOnYear2 = alarmReportService.getAlarmCountYearOnYear(map);
        //告警分系统排名
        Map<String, Object> systemRank = alarmReportService.getAlarmBySystemRank(map);
        ////火警趋势图
        Map<String, Object> fireChart = alarmReportService.getAlarmFireChart(map);
        ////传感器告警数量统计
        Map<String, Object> sensor = alarmReportService.getAlarmSensor(map);
        //告警处理情况统计
        Map<String, Object> handle = alarmReportService.getAlarmHandle(map);
        //故障趋势图
        Map<String, Object> hitchChart = alarmReportService.getAlarmHitchChart(map);
        return ResponseVO.<Object>success().setData(map);
    }

}
