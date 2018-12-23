package cn.com.bgy.ifc.service.interfaces.inner.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备信息service
 **/

public interface EquipmentInfoService {

    void queryListEquipmentInfo();

    int addEquipmentInfo( EquipmentInfo equipmentInfo );

    int updateEquipmentInfo(EquipmentInfo equipmentInfo);

    int deleteEquipmentInfo(String str);


}
