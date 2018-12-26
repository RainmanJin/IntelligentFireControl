package cn.com.bgy.ifc.dao.maintenance;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceOrderWithBLOBs;

public interface MaintenanceOrderDao {
    int insert(MaintenanceOrderWithBLOBs record);

    int insertSelective(MaintenanceOrderWithBLOBs record);
}