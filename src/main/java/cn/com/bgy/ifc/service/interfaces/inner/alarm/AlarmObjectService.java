package cn.com.bgy.ifc.service.interfaces.inner.alarm;

import cn.com.bgy.ifc.entity.po.alarm.AlarmObject;
import cn.com.bgy.ifc.entity.vo.alarm.AlarmObjectVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;


/**
 * @author: ZhangCheng
 * @description:告警对象
 * @date: 2019-01-19 17:20
 **/
public interface AlarmObjectService extends BaseService<AlarmObject> {

    PageInfo<AlarmObject> queryListByPage(Page<AlarmObject> page, AlarmObjectVo alarmObjectVo);

}
