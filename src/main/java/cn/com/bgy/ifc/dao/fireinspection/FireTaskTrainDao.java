package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.fireinspection.FireTaskTrain;
import cn.com.bgy.ifc.entity.vo.fireinspection.FireTaskTrainVo;
import java.util.List;

public interface FireTaskTrainDao extends BaseDao<FireTaskTrain> {

    List<FireTaskTrain> queryListByPage(FireTaskTrainVo fireTaskTrainVo);

}