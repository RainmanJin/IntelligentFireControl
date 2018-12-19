package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.entity.po.repair.MaintenanceContract;

public interface MaintenanceContractDao {
    int insert(MaintenanceContract record);

    int insertSelective(MaintenanceContract record);
}