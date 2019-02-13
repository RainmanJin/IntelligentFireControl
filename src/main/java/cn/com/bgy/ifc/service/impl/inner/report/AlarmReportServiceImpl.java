package cn.com.bgy.ifc.service.impl.inner.report;

import cn.com.bgy.ifc.dao.report.AlarmReportDao;
import cn.com.bgy.ifc.service.interfaces.inner.report.AlarmReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: chenlie
 * @description:
 * @date: 2019/2/12 16:28
 */
@Service
public class AlarmReportServiceImpl implements AlarmReportService {

    @Autowired
    private AlarmReportDao alarmReportDao;

    /**
     * @description:获取火警和告警
     * @param: [map]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: chenlie
     * @date: 2019/2/13 9:37
     */
    @Override
    public Map<String, Object> getAlarmCount(Map<String, Object> map) {

        return null;
    }
    /**
     * @description:获取同比数据
     * @param: [map]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: chenlie
     * @date: 2019/2/13 9:38
     */
    @Override
    public Map<String, Object> getAlarmCountYearOnYear(Map<String, Object> map) {

        return null;
    }
    /**
     * @description:获取环比数据
     * @param: [map]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: chenlie
     * @date: 2019/2/13 9:38
     */
    @Override
    public Map<String, Object> getAlarmCountChainRatio(Map<String, Object> map) {

        return null;
    }
    /**
     * @description:告警分系统统计
     * @param: [map]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: chenlie
     * @date: 2019/2/13 9:39
     */
    @Override
    public Map<String, Object> getAlarmBySystem(Map<String, Object> map) {

        return null;
    }
    /**
     * @description:
     * @param: [map]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: chenlie
     * @date: 2019/2/13 9:39
     */
    @Override
    public Map<String, Object> getAlarmByItem(Map<String, Object> map) {

        return null;
    }

    @Override
    public Map<String, Object> getAlarmHandle(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, Object> getAlarmSensor(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, Object> getAlarmBySystemRank(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, Object> getAlarmByRegionRank(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, Object> getAlarmFireChart(Map<String, Object> map) {
        return null;
    }

    @Override
    public Map<String, Object> getAlarmHitchChart(Map<String, Object> map) {
        return null;
    }
}
