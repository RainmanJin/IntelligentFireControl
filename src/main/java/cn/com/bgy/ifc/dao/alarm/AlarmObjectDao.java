package cn.com.bgy.ifc.dao.alarm;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.alarm.AlarmObject;
import cn.com.bgy.ifc.entity.vo.alarm.AlarmObjectVo;

import java.util.List;

public interface AlarmObjectDao  extends BaseDao<AlarmObject> {

    List<AlarmObject> queryListByParam(AlarmObjectVo alarmObjectVo);
}