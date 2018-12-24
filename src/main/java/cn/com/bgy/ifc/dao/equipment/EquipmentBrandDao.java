package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentBrand;

import java.util.List;
import java.util.Map;

public interface EquipmentBrandDao extends BaseDao<EquipmentBrand> {


    List<Map<String,Object>> queryListEquipmentBrand(String keyword);

    int updateEquipmentBrand( EquipmentBrand equipmentBrand );

    int deleteEquipmentBrand( List<Long> list );

    List<Map<String,Object>> queryAllEquipmentBrand();
}