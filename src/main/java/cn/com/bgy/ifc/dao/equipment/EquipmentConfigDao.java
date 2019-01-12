package cn.com.bgy.ifc.dao.equipment;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.equipment.EquipmentConfig;

import java.util.List;

/**
 * @author zhangcheng
 */
public interface EquipmentConfigDao extends BaseDao<EquipmentConfig> {

    int replaceConfigList(List<EquipmentConfig> list);
}