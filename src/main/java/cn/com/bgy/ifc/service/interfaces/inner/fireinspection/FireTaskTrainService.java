package cn.com.bgy.ifc.service.interfaces.inner.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskTrain;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskTrainVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:消防培训任务
 * @date: 2019-01-04 11:07
 **/
public interface FireTaskTrainService extends BaseService<FireTaskTrain> {

    /**
     * 分页查询
     * @param page
     * @param fireTaskTrainVo
     * @return
     */
    PageInfo<FireTaskTrain> queryListByPage(Page<FireTaskTrain> page, FireTaskTrainVo fireTaskTrainVo);
}
