package cn.com.bgy.ifc.service.impl.inner.alarm;

import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.dao.equipment.EquipmentEventDao;
import cn.com.bgy.ifc.entity.po.alarm.AlarmCount;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:实时告警
 * @date: 2019-01-18 10:33
 **/
@Service
public class AlarmServiceImpl implements AlarmService {

    @Resource
    private EquipmentEventDao equipmentEventDao;

    @Override
    public PageInfo<EquipmentEvent> queryListByPage(Page page, Integer type) {
        EquipmentEvent equipmentEvent = new EquipmentEvent();
        equipmentEvent.setStatus(EquipmentConstant.EventState.NORMAL.getValue());
        equipmentEvent.setType(type);
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentEvent> list = equipmentEventDao.queryAlarmList(equipmentEvent);
        PageInfo<EquipmentEvent> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public AlarmCount queryAlarmCount() {
        return equipmentEventDao.queryAlarmCount();
    }
}
