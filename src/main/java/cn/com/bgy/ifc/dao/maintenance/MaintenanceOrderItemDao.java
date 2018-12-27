package cn.com.bgy.ifc.dao.maintenance;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrderItem;

public interface MaintenanceOrderItemDao {
    int insert(MaintenanceOrderItem record);

    int insertSelective(MaintenanceOrderItem record);
}