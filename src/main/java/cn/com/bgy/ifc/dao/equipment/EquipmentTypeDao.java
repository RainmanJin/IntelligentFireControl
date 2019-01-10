package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentType;

import java.util.List;
import java.util.Map;

public interface EquipmentTypeDao extends BaseDao<EquipmentType> {

    List<Map<String,Object>> queryListEquipmentType(Map<String,Object> map);


    int deleteEquipmentType( List<Long> list );

    List<Map<String,Object>> queryEquipmentTypeBySuperId( Long id );

    Long queryBySuperIdRtrueSuperId( Long id );

    List<Map<String,Object>> queryAllEquipmentType();

    /**
     * 查询所有设备类型
     * @param equipmentType
     * @return
     */
    List<EquipmentType>  queryAllList(EquipmentType equipmentType);
}