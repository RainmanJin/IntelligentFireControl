package cn.com.bgy.ifc.service.impl.inner.alarm;

import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.dao.alarm.AlarmObjectDao;
import cn.com.bgy.ifc.entity.po.alarm.AlarmObject;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmObjectService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:告警对象
 * @date: 2019-01-19 17:21
 **/
@Service
public class AlarmObjectServiceImpl implements AlarmObjectService {

    @Resource
    private AlarmObjectDao alarmObjectDao;

    @Override
    public AlarmObject findById(Long id) {
        return alarmObjectDao.findById(id);
    }

    @Override
    public int insert(AlarmObject alarmObject) {
        alarmObject.setState(SystemConstant.EnableState.ENABLE.getValue());
        alarmObject.setCreateTime(new Date());
        alarmObject.setLogicRemove(false);
        return alarmObjectDao.insert(alarmObject);
    }

    @Override
    public int insertSelective(AlarmObject alarmObject) {
        alarmObject.setState(SystemConstant.EnableState.ENABLE.getValue());
        alarmObject.setCreateTime(new Date());
        alarmObject.setLogicRemove(false);
        return alarmObjectDao.insertSelective(alarmObject);
    }

    @Override
    public int update(AlarmObject alarmObject) {
        alarmObject.setCreateTime(new Date());
        return alarmObjectDao.update(alarmObject);
    }

    @Override
    public int updateSelective(AlarmObject alarmObject) {
        alarmObject.setCreateTime(new Date());
        return alarmObjectDao.updateSelective(alarmObject);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return alarmObjectDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<AlarmObject> queryListByPage(Page<AlarmObject> page, AlarmObject alarmObject) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<AlarmObject> list = alarmObjectDao.queryListByParam(alarmObject);
        PageInfo<AlarmObject> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
