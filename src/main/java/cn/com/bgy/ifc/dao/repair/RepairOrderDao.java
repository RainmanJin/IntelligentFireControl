package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.repair.RepairOrder;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RepairOrderDao extends BaseDao<RepairOrder> {


    List<Map<String,Object>> queryListRepairOrder(@Param("params") Map<String, Object> params);

    Map<String,Object> queryRepairOrderById( Long id );

    int deleteRepairOrder( List<Long> list );

    //根据ID查询订单是否可以删除
    List<Long> queryRepairOrderIsDelete(List<Long> list);
    //查询订单是否可以修改
    int queryRepairOrderIsUpdate( Long id );
    //修改
    int updateRepairOrder( RepairOrder repairOrder );

    RepairOrder queryRepairOrderByExtendId(Integer extendId);
}