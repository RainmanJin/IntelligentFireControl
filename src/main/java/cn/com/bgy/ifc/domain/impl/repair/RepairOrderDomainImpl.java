package cn.com.bgy.ifc.domain.impl.repair;

import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.dao.repair.RepairOrderDao;
import cn.com.bgy.ifc.domain.interfaces.repair.RepairOrderDomain;
import cn.com.bgy.ifc.entity.po.repair.RepairOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author huxin
 * @Date 2018/12/26 16:51
 * @Description  招修工单DomianImpl
 **/
@Service
public class RepairOrderDomainImpl implements RepairOrderDomain {

    @Resource
    private EquipmentInfoDao equipmentInfoDao;

    @Resource
    private RepairOrderDao repairOrderDao;

    /**
     * @Author huxin
     * @Description 根据传入的信息，添加订单信息
     * @Date 2018/12/26 16:56
     */
    @Override
    public int launchRepair( RepairOrder repairOrder ) {

        if(repairOrder.getEquipmentId()!=null||repairOrder.getEquipmentId()>0){
            //根据设备id查询机房ID
            Long roomId = equipmentInfoDao.queryRoomIdByEquipmentId(repairOrder.getEquipmentId());
            if(roomId!=null || roomId>0){
                repairOrder.setComputerRoomId(roomId);
                repairOrder.setCreateTime(new Date());
                repairOrder.setState(0);
                repairOrder.setPush(false);
                repairOrder.setLogicRemove(false);
                return  repairOrderDao.insert(repairOrder);
            }
            return 0;
        }
        return 0;
    }
}
