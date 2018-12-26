package cn.com.bgy.ifc.dao.maintenance;

import cn.com.bgy.ifc.entity.po.maintenance.MaintenanceContractFile;

public interface MaintenanceContractFileDao {
    int insert(MaintenanceContractFile record);

    int insertSelective(MaintenanceContractFile record);
}