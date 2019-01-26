package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.dao.equipment.EquipmentSetupDao;
import cn.com.bgy.ifc.dao.equipment.EquipmentStateDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentSetup;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentSetupService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-26 11:37
 **/
@Service
public class EquipmentSetupServiceImpl implements EquipmentSetupService {

    @Autowired
    private EquipmentStateService equipmentStateService;

    @Resource
    private EquipmentSetupDao equipmentSetupDao;

    @Resource
    private EquipmentStateDao equipmentStateDao;

    @Override
    public EquipmentSetup findById(Long id) {
        return equipmentSetupDao.findById(id);
    }

    @Override
    public int insert(EquipmentSetup equipmentSetup) {
        return equipmentSetupDao.insert(equipmentSetup);
    }

    @Override
    public int insertSelective(EquipmentSetup equipmentSetup) {
        return equipmentSetupDao.insertSelective(equipmentSetup);
    }

    @Override
    public int update(EquipmentSetup equipmentSetup) {
        return equipmentSetupDao.update(equipmentSetup);
    }

    @Override
    public int updateSelective(EquipmentSetup equipmentSetup) {
        return equipmentSetupDao.updateSelective(equipmentSetup);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return equipmentSetupDao.deleteBatch(ids);
    }

    @Override
    public int updateAlarmGrade(EquipmentSetup equipmentSetup) {
        if(equipmentSetup.getId()!=null){
            EquipmentSetup oldSetup=equipmentSetupDao.findById(equipmentSetup.getId());
            if(oldSetup!=null){
                oldSetup.setGrade(equipmentSetup.getGrade());
                return equipmentSetupDao.update(oldSetup);
            }else{
                return equipmentSetupDao.insertSelective(equipmentSetup);
            }
        }
        return 0;
    }

    @Override
    public int updateAlarmThreshold(EquipmentSetup equipmentSetup) {
        EquipmentState equipmentState=equipmentStateDao.findById(equipmentSetup.getId());
        if(equipmentState!=null){
            equipmentState.setValueThresholdMax(equipmentSetup.getValueThresholdMax());
            equipmentState.setValueThresholdMin(equipmentSetup.getValueThresholdMin());
            ResponseVO<Object> response=equipmentStateService.editEquipmentState(equipmentState);
            if(response.getCode().equals(ResponseVO.SUCCESS)){
                EquipmentSetup oldSetup=equipmentSetupDao.findById(equipmentSetup.getId());
                if(oldSetup!=null){
                    oldSetup.setAlarmThresholdMax(equipmentSetup.getAlarmThresholdMax());
                    oldSetup.setAlarmThresholdMin(equipmentSetup.getAlarmThresholdMin());
                    return equipmentSetupDao.update(oldSetup);
                }else{
                    return equipmentSetupDao.insertSelective(equipmentSetup);
                }
            }
        }
        return 0;
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public int updateAlarmGradeList(List<EquipmentSetup> list) {
        for(EquipmentSetup setup:list){
            equipmentSetupDao.replaceSelective(setup);
        }
        return 1;
    }

    @Transactional(rollbackFor = {RuntimeException.class})
    @Override
    public int updateAlarmThresholdList(List<EquipmentSetup> list) {
        int count=0;
        for(EquipmentSetup setup:list){
           int result=updateAlarmThreshold(setup);
           if(result==1){
              count++;
           }
        }
        return count;
    }
}
