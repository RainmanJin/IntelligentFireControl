package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;

import java.util.List;

public interface EquipmentInfoDao extends BaseDao<EquipmentInfo> {


    void queryListEquipmentInfo();

    int updateEquipmentInfo( EquipmentInfo equipmentInfo);

    int deleteEquipmentInfo(List<Long> list);


}