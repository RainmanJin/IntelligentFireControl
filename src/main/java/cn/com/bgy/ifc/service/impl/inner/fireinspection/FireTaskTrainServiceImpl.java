package cn.com.bgy.ifc.service.impl.inner.fireinspection;

import cn.com.bgy.ifc.dao.fireinspection.FireTaskTrainDao;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskTrain;
import cn.com.bgy.ifc.service.interfaces.inner.fireinspection.FireTaskTrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:消防培训任务
 * @date: 2019-01-04 11:08
 **/
@Service
public class FireTaskTrainServiceImpl implements FireTaskTrainService {
    @Resource
    private FireTaskTrainDao fireTaskTrainDao;

    @Override
    public FireTaskTrain findById(Long id) {
        return fireTaskTrainDao.findById(id);
    }

    @Override
    public int insert(FireTaskTrain fireTaskTrain) {
        return fireTaskTrainDao.insert(fireTaskTrain);
    }

    @Override
    public int insertSelective(FireTaskTrain fireTaskTrain) {
        return fireTaskTrainDao.insertSelective(fireTaskTrain);
    }

    @Override
    public int update(FireTaskTrain fireTaskTrain) {
        return fireTaskTrainDao.update(fireTaskTrain);
    }

    @Override
    public int updateSelective(FireTaskTrain fireTaskTrain) {
        return fireTaskTrainDao.updateSelective(fireTaskTrain);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return fireTaskTrainDao.deleteBatch(ids);
    }
}
