package cn.com.bgy.ifc.service.impl.inner.alarm;

import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentEventDao;
import cn.com.bgy.ifc.entity.po.alarm.AlarmCount;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.alarm.AlarmVo;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
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
    public PageInfo<AlarmVo> queryListByPage(Page page, Integer type) {
        EquipmentEvent equipmentEvent = new EquipmentEvent();
        equipmentEvent.setStatus(EquipmentConstant.EventState.NORMAL.getValue());
        equipmentEvent.setType(type);
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<EquipmentEvent> list = equipmentEventDao.queryAlarmList(equipmentEvent);
        List<AlarmVo> alarmList = new ArrayList<>();
        for (EquipmentEvent event : list) {
            AlarmVo alarmVo = new AlarmVo();
            alarmVo.setId(event.getId());
            alarmVo.setReportCount(event.getReportCount());
            alarmVo.setDescription(event.getDescription());
            Date firstTime = event.getFirstTime();
            Date lastTime = event.getLastTime();
            alarmVo.setLastTime(lastTime);
            alarmVo.setAlarmDuration(TimeUtil.timeDifference(firstTime, lastTime));
            StringBuilder stringBuilder=new StringBuilder();
            if(event.getRegionInfo()!=null){
                stringBuilder.append(event.getRegionInfo().getName());
            }
            if (event.getRegionProject() != null) {
                stringBuilder.append(event.getRegionProject().getName());
            }
            alarmVo.setProjectName(stringBuilder.toString());
            if (event.getRegionComputerRoom() != null) {
                alarmVo.setComputerRoomName(event.getRegionComputerRoom().getName());
            }
            if (event.getEquipmentState() != null) {
                alarmVo.setAlarmValue(event.getEquipmentState().getLastValue());
                if(event.getEquipmentState().getValueThresholdMin()!=null&&event.getEquipmentState().getValueThresholdMax()!=null){
                    alarmVo.setReferenceRange(event.getEquipmentState().getValueThresholdMin() + "-" + event.getEquipmentState().getValueThresholdMax());
                }
                if(event.getEquipmentState().getAlarmThresholdMin()!=null&&event.getEquipmentState().getAlarmThresholdMax()!=null){
                    alarmVo.setAlarmReferenceRange(event.getEquipmentState().getAlarmThresholdMin() + "-" + event.getEquipmentState().getAlarmThresholdMax());
                }
                if(event.getEquipmentState().getGrade()!=null){
                    alarmVo.setAlarmGrade(event.getEquipmentState().getGrade());
                }
            }
            alarmVo.setDeviceName(event.getDeviceName());
            alarmList.add(alarmVo);
        }
        PageInfo<AlarmVo> pageInfo = new PageInfo<>(alarmList);
        return pageInfo;
    }

    @Override
    public AlarmCount queryAlarmCount() {
        return equipmentEventDao.queryAlarmCount();
    }
}
