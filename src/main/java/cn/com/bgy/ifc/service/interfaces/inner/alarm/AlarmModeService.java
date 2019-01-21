package cn.com.bgy.ifc.service.interfaces.inner.alarm;

import cn.com.bgy.ifc.entity.po.alarm.AlarmMode;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:告警方式
 * @date: 2019-01-21 12:01
 **/
public interface AlarmModeService extends BaseService<AlarmMode> {

    /**
     * 分页查询告警方式
     * @param page
     * @param alarmMode
     * @return
     */
    PageInfo<AlarmMode> queryListByPage(Page<AlarmMode> page, AlarmMode alarmMode);

    /**
     * 查询所有告警方式
     * @return
     */
    List<AlarmMode> queryAllList();
}
