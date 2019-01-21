package cn.com.bgy.ifc.service.impl.inner.alarm;

import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.dao.alarm.AlarmModeDao;
import cn.com.bgy.ifc.entity.po.alarm.AlarmMode;
import cn.com.bgy.ifc.service.interfaces.inner.alarm.AlarmModeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:告警方式
 * @date: 2019-01-21 12:02
 **/
@Service
public class AlarmModeServiceImpl implements AlarmModeService {

    @Resource
    private AlarmModeDao alarmModeDao;

    @Override
    public AlarmMode findById(Long id) {
        return alarmModeDao.findById(id);
    }

    @Override
    public int insert(AlarmMode alarmMode) {
        alarmMode.setState(SystemConstant.EnableState.ENABLE.getValue());
        alarmMode.setCreateTime(new Date());
        alarmMode.setLogicRemove(false);
        return alarmModeDao.insert(alarmMode);
    }

    @Override
    public int insertSelective(AlarmMode alarmMode) {
        alarmMode.setState(SystemConstant.EnableState.ENABLE.getValue());
        alarmMode.setCreateTime(new Date());
        alarmMode.setLogicRemove(false);
        return alarmModeDao.insertSelective(alarmMode);
    }

    @Override
    public int update(AlarmMode alarmMode) {
        alarmMode.setCreateTime(new Date());
        return alarmModeDao.update(alarmMode);
    }

    @Override
    public int updateSelective(AlarmMode alarmMode) {
        alarmMode.setCreateTime(new Date());
        return alarmModeDao.updateSelective(alarmMode);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return alarmModeDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<AlarmMode> queryListByPage(Page<AlarmMode> page, AlarmMode alarmMode) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<AlarmMode> list = alarmModeDao.queryListByParam(alarmMode);
        PageInfo<AlarmMode> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<AlarmMode> queryAllList() {
        AlarmMode alarmMode=new  AlarmMode();
        alarmMode.setState(SystemConstant.EnableState.ENABLE.getValue());
        return alarmModeDao.queryListByParam(alarmMode);
    }
}
