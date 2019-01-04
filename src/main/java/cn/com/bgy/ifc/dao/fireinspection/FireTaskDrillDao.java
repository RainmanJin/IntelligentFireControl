package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskDrill;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskDrillVo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-04 10:23
 **/
public interface FireTaskDrillDao extends BaseDao<FireTaskDrill> {

    List<FireTaskDrill> queryListByPage(FireTaskDrillVo fireTaskDrillVo);
}
