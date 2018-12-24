package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.entity.po.repair.MaintenanceContractFile;

public interface MaintenanceContractFileDao {
    int insert(MaintenanceContractFile record);

    int insertSelective(MaintenanceContractFile record);
}