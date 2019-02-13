package cn.com.bgy.ifc.dao.alarm;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.alarm.AlarmCount;
import cn.com.bgy.ifc.entity.po.alarm.RealTimeAlarm;

import java.util.List;

public interface RealTimeAlarmDao  extends BaseDao<RealTimeAlarm> {

    /**
     *
     * @param id
     * @return
     */
    RealTimeAlarm findByEventId(Long id);

    /**
     * 查询设备实时告警列表
     * @param realTimeAlarm
     * @return
     */
    List<RealTimeAlarm> queryAlarmList(RealTimeAlarm realTimeAlarm);

    /**
     * 查询告警统计
     * @return
     */
    AlarmCount queryAlarmCount();
}