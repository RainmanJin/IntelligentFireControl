package cn.com.bgy.ifc.service.impl.inner.equipment;

import cn.com.bgy.ifc.domain.interfaces.system.equipment.EquipmentVersionDomain;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备型号
 **/
@Service
public class EquipmentVersionServiceImpl implements EquipmentVersionService {

    @Autowired
    private EquipmentVersionDomain equipmentVersionDomain;

    @Override
    public void queryListEquipmentVersion() {

    }

    @Override
    public int addEquipmentVersion( EquipmentVersion record ) {
        return equipmentVersionDomain.addEquipmentVersion(record);
    }

    @Override
    public int updateEquipmentVersion( EquipmentVersion record ) {
        return equipmentVersionDomain.updateEquipmentVersion(record);
    }

    @Override
    public int deleteEquipmentVersion( String str ) {
        return equipmentVersionDomain.deleteEquipmentVersion(str);
    }
}
