package cn.com.bgy.ifc.domain.interfaces.system.equipment;

import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;

/**
 * @Author huxin
 * @Date 2018/12/21 11:13
 * @Description 设备信息domain
 **/

public interface EquipmentInfoDomain {

    void queryListEquipmentInfo();

    int addEquipmentInfo( EquipmentInfo equipmentInfo );

    int updateEquipmentInfo(EquipmentInfo equipmentInfo);

    int deleteEquipmentInfo(String str);

}
