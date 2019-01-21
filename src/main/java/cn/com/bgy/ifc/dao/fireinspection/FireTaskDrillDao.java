package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskDrill;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskDrillVo;

import java.util.List;

public interface FireTaskDrillDao extends BaseDao<FireTaskDrill> {

    List<FireTaskDrill> queryListByPage(FireTaskDrillVo fireTaskDrillVo);
}