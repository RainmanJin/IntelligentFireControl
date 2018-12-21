package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentVersion;

import java.util.List;

public interface EquipmentVersionDao extends BaseDao<EquipmentVersion> {

    int insertSelective(EquipmentVersion record);

    void queryListEquipmentVersion();

    int updateEquipmentVersion(EquipmentVersion record);

    int deleteEquipmentVersion( List<Long> list );
}