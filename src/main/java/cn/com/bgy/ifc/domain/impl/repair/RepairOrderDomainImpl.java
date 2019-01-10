package cn.com.bgy.ifc.domain.impl.repair;

import cn.com.bgy.ifc.dao.equipment.EquipmentInfoDao;
import cn.com.bgy.ifc.dao.repair.RepairOrderDao;
import cn.com.bgy.ifc.domain.interfaces.repair.RepairOrderDomain;
import cn.com.bgy.ifc.entity.po.repair.RepairOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
                repairOrder.setCreateTime(new Date());
                repairOrder.setState(-1);
                repairOrder.setLogicRemove(false);
                return  repairOrderDao.insert(repairOrder);
            }
            return 0;
    }

    @Override
    public List<RepairOrder> queryListByParam(RepairOrder repairOrder) {
        return repairOrderDao.queryListByParam(repairOrder);
    }

    @Override
    public List<RepairOrder> queryListByMap(Map<String, Object> map) {
        return repairOrderDao.queryListByMap(map);
    }

    @Override
    public RepairOrder findById(Long id) {
        return repairOrderDao.findById(id);
    }

    @Override
    public int insert(RepairOrder repairOrder) {
        return repairOrderDao.insert(repairOrder);
    }

    @Override
    public int insertSelective(RepairOrder repairOrder) {
        return repairOrderDao.insertSelective(repairOrder);
    }

    @Override
    public int update(RepairOrder repairOrder) {
        return repairOrderDao.update(repairOrder);
    }

    @Override
    public int updateSelective(RepairOrder repairOrder) {
        return updateSelective(repairOrder);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return repairOrderDao.deleteBatch(ids);
    }
}
