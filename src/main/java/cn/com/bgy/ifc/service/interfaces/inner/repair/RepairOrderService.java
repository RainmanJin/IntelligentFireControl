package cn.com.bgy.ifc.service.interfaces.inner.repair;

import cn.com.bgy.ifc.entity.po.repair.RepairOrder;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/26 11:46
 * @Description 设备招修
 **/

public interface RepairOrderService {


    ResponseVO<Object> launchRepair( RepairOrder repairOrder );


    PageInfo queryListRepairOrder( Page<Object> page ,Map<String, Object> params );

    Map<String,Object> queryRepairOrderById( Long id );

    int deleteRepairOrder( String arr );

    int updateRepairOrder( RepairOrder repairOrder );

    RepairOrder queryRepairOrderByExtendId(Integer extendId);
}
