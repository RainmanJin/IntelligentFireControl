package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.entity.po.repair.MaintenanceOrderWithBLOBs;

public interface MaintenanceOrderDao {
    int insert(MaintenanceOrderWithBLOBs record);

    int insertSelective(MaintenanceOrderWithBLOBs record);
}