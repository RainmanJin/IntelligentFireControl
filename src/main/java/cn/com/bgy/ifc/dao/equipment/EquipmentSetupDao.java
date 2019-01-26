package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentSetup;

public interface EquipmentSetupDao extends BaseDao<EquipmentSetup> {

    int replaceSelective(EquipmentSetup equipmentSetup);

}