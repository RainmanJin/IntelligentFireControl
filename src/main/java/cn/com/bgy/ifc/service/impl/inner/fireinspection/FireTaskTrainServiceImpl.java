package cn.com.bgy.ifc.service.impl.inner.fireinspection;

import cn.com.bgy.ifc.dao.fireinspection.FireTaskTrainDao;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskTrain;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskTrainVo;
import cn.com.bgy.ifc.service.interfaces.inner.fireinspection.FireTaskTrainService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
        fireTaskTrain.setCreateTime(new Date());
        fireTaskTrain.setLogicRemove(false);
        return fireTaskTrainDao.insert(fireTaskTrain);
    }

    @Override
    public int insertSelective(FireTaskTrain fireTaskTrain) {
        fireTaskTrain.setCreateTime(new Date());
        fireTaskTrain.setLogicRemove(false);
        return fireTaskTrainDao.insertSelective(fireTaskTrain);
    }

    @Override
    public int update(FireTaskTrain fireTaskTrain) {
        fireTaskTrain.setCreateTime(new Date());
        return fireTaskTrainDao.update(fireTaskTrain);
    }

    @Override
    public int updateSelective(FireTaskTrain fireTaskTrain) {
        fireTaskTrain.setCreateTime(new Date());
        return fireTaskTrainDao.updateSelective(fireTaskTrain);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return fireTaskTrainDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<FireTaskTrain> queryListByPage(Page<FireTaskTrain> page, FireTaskTrainVo fireTaskTrainVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<FireTaskTrain> list = fireTaskTrainDao.queryListByPage(fireTaskTrainVo);
        PageInfo<FireTaskTrain> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
