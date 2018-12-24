package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfo;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentInfoView;

import java.util.List;
import java.util.Map;

public interface EquipmentInfoDao extends BaseDao<EquipmentInfo> {


    List<Map<String,Object>> queryListEquipmentInfo(EquipmentInfoView equipmentInfoView);

    int updateEquipmentInfo( EquipmentInfo equipmentInfo);

    int deleteEquipmentInfo(List<Long> list);

    Map<String,Object> queryEquipmentInfoById(Long id);
}