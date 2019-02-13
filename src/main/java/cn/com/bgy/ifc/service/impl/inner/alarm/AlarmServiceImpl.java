package cn.com.bgy.ifc.service.impl.inner.alarm;

import cn.com.bgy.ifc.bgy.constant.EquipmentConstant;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.dao.alarm.RealTimeAlarmDao;
import cn.com.bgy.ifc.entity.po.alarm.AlarmCount;
import cn.com.bgy.ifc.entity.po.alarm.RealTimeAlarm;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentEvent;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.alarm.AlarmVo;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentEventService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RealTimeAlarmDao realTimeAlarmDao;

    @Autowired
    private EquipmentEventService equipmentEventService;

    @Override
    public PageInfo<AlarmVo> queryListByPage(Page page, Integer type) {
        RealTimeAlarm realTimeAlarm = new RealTimeAlarm();
        realTimeAlarm.setStatus(EquipmentConstant.EventState.NORMAL.getValue());
        realTimeAlarm.setType(type);
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<RealTimeAlarm> list = realTimeAlarmDao.queryAlarmList(realTimeAlarm);
        List<AlarmVo> alarmList = new ArrayList<>();
        for (RealTimeAlarm alarm : list) {
            AlarmVo alarmVo = new AlarmVo();
            alarmVo.setId(alarm.getId());
            alarmVo.setReportCount(alarm.getReportCount());
            alarmVo.setDescription(alarm.getDescription());
            Date firstTime = alarm.getFirstTime();
            Date lastTime = alarm.getLastTime();
            alarmVo.setLastTime(lastTime);
            alarmVo.setAlarmDuration(TimeUtil.timeDifference(firstTime, lastTime));
            StringBuilder stringBuilder=new StringBuilder();
            if(alarm.getRegionInfo()!=null){
                stringBuilder.append(alarm.getRegionInfo().getName());
            }
            if (alarm.getRegionProject() != null) {
                stringBuilder.append(alarm.getRegionProject().getName());
            }
            alarmVo.setProjectName(stringBuilder.toString());
            if (alarm.getRegionComputerRoom() != null) {
                alarmVo.setComputerRoomName(alarm.getRegionComputerRoom().getName());
            }
            if (alarm.getEquipmentState() != null) {
                if(alarm.getEquipmentState().getValueThresholdMin()!=null&&alarm.getEquipmentState().getValueThresholdMax()!=null){
                    alarmVo.setReferenceRange(alarm.getEquipmentState().getValueThresholdMin() + "-" + alarm.getEquipmentState().getValueThresholdMax());
                }
                if(alarm.getEquipmentState().getAlarmThresholdMin()!=null&&alarm.getEquipmentState().getAlarmThresholdMax()!=null){
                    alarmVo.setAlarmReferenceRange(alarm.getEquipmentState().getAlarmThresholdMin() + "-" + alarm.getEquipmentState().getAlarmThresholdMax());
                }
                if(alarm.getEquipmentState().getGrade()!=null){
                    alarmVo.setAlarmGrade(alarm.getEquipmentState().getGrade());
                }
            }
            alarmVo.setAlarmValue(alarm.getAlarmValue());
            alarmVo.setDeviceName(alarm.getEquipmentInfo().getName());
            alarmList.add(alarmVo);
        }
        PageInfo<AlarmVo> pageInfo = new PageInfo<>(alarmList);
        return pageInfo;
    }

    @Override
    public AlarmCount queryAlarmCount() {
        return realTimeAlarmDao.queryAlarmCount();
    }

    @Override
    public ResponseVO<Object> editAlarm(Long id) {
        RealTimeAlarm realTimeAlarm =realTimeAlarmDao.findById(id);
        int status=EquipmentConstant.EventState.FAULT.getValue();
        //修改为已处理
        realTimeAlarm.setStatus(status);
        if(realTimeAlarm.getEventId()!=null){
            EquipmentEvent equipmentEvent = equipmentEventService.findById(realTimeAlarm.getEventId());
            if(equipmentEvent==null){
                return ResponseVO.error().setMsg("获取告警信息异常，请刷新后重试！");
            }
            equipmentEvent.setStatus(status);
            ResponseVO<Object> response = equipmentEventService.editEquipmentEvent(equipmentEvent);
            if (response.getCode().equals(ResponseVO.SUCCESS)) {
                realTimeAlarmDao.updateSelective(realTimeAlarm);
                return ResponseVO.success().setMsg("处理设备告警成功!");
            }else{
                return ResponseVO.error().setMsg("处理设备告警失败!");
            }
        }
        int result=realTimeAlarmDao.updateSelective(realTimeAlarm);
        if (result == 1) {
            return ResponseVO.success().setMsg("处理设备告警成功!");
        } else {
            return ResponseVO.error().setMsg("处理设备告警失败!");
        }
    }

    @Override
    public ResponseVO<Object> handleDataList(String ids) {
        List<Long> idList = ListUtil.getListId(ids);
        int count = 0;
        for (Long id : idList) {
            RealTimeAlarm realTimeAlarm =realTimeAlarmDao.findById(id);
            int status=EquipmentConstant.EventState.FAULT.getValue();
            //修改为已处理
            realTimeAlarm.setStatus(status);
            if(realTimeAlarm.getEventId()!=null){
                EquipmentEvent equipmentEvent = equipmentEventService.findById(realTimeAlarm.getEventId());
                if(equipmentEvent!=null){
                    equipmentEvent.setStatus(status);
                    ResponseVO<Object> response = equipmentEventService.editEquipmentEvent(equipmentEvent);
                    if (response.getCode().equals(ResponseVO.SUCCESS)) {
                        realTimeAlarmDao.updateSelective(realTimeAlarm);
                        count++;
                    }
                }
            }else{
                int result=realTimeAlarmDao.updateSelective(realTimeAlarm);
                if (result == 1) {
                    count++;
                }
            }
        }
        if (count > 0) {
            return ResponseVO.success().setMsg("批量处理设备告警成功，处理条数：" + count);
        } else {
            return ResponseVO.error().setMsg("批量处理设备告警失败!");
        }
    }
}
