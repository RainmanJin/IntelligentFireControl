package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;

/**
 * @Author huxin
 * @Date 2018/12/21 16:22
 * @Description 设备型号
 **/

public interface EquipmentVersionService  {


    void queryListEquipmentVersion();

    int addEquipmentVersion(EquipmentVersion record);

    int updateEquipmentVersion(EquipmentVersion record);

    int deleteEquipmentVersion( String str );

}
