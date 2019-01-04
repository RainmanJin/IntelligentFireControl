package cn.com.bgy.ifc.service.impl.inner.fireinspection;

import cn.com.bgy.ifc.dao.fireinspection.FireTaskDrillDao;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskDrill;
import cn.com.bgy.ifc.service.interfaces.inner.fireinspection.FireTaskDrillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:消防演练任务
 * @date: 2019-01-04 10:28
 **/
@Service
public class FireTaskDrillServiceImpl implements FireTaskDrillService {

    @Resource
    private FireTaskDrillDao fireTaskDrillDao;

    @Override
    public FireTaskDrill findById(Long id) {
        return fireTaskDrillDao.findById(id);
    }

    @Override
    public int insert(FireTaskDrill fireTaskDrill) {
        return fireTaskDrillDao.insert(fireTaskDrill);
    }

    @Override
    public int insertSelective(FireTaskDrill fireTaskDrill) {
        return fireTaskDrillDao.insertSelective(fireTaskDrill);
    }

    @Override
    public int update(FireTaskDrill fireTaskDrill) {
        return fireTaskDrillDao.update(fireTaskDrill);
    }

    @Override
    public int updateSelective(FireTaskDrill fireTaskDrill) {
        return fireTaskDrillDao.updateSelective(fireTaskDrill);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return fireTaskDrillDao.deleteBatch(ids);
    }
}
