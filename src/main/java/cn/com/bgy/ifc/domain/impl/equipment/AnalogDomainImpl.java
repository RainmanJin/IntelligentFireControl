package cn.com.bgy.ifc.domain.impl.equipment;

import cn.com.bgy.ifc.dao.equipment.AnalogDao;
import cn.com.bgy.ifc.dao.equipment.EquipmentStateDao;
import cn.com.bgy.ifc.domain.interfaces.equipment.AnalogDomain;
import cn.com.bgy.ifc.entity.po.equipment.Analog;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2019-01-24 09:02
 **/
@Service
public class AnalogDomainImpl implements AnalogDomain {

    @Resource
    private AnalogDao analogDao;

    @Resource
    private EquipmentStateDao equipmentStateDao;

    @Override
    public int insertAnalogAndState(Analog analog) {
        if(analog.getDeviceId()!=null){
            Long deviceId=analog.getDeviceId();
            EquipmentState equipmentState=equipmentStateDao.findById(deviceId);
            if(equipmentState!=null){
                equipmentState.setLastValue(analog.getValue());
                equipmentStateDao.updateSelective(equipmentState);
            }
        }
        return analogDao.insertSelective(analog);
    }
}
