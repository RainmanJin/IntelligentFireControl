package cn.com.bgy.ifc.service.interfaces.inner.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskDrill;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskDrillVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:消防演练任务
 * @date: 2019-01-04 10:27
 **/
public interface FireTaskDrillService extends BaseService<FireTaskDrill> {

    /**
     * 分页查询
     * @param page
     * @param fireTaskDrillVo
     * @return
     */
    PageInfo<FireTaskDrill> queryListByPage(Page<FireTaskDrill> page, FireTaskDrillVo fireTaskDrillVo);
}
