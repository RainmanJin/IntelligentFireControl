package cn.com.bgy.ifc.dao.repair;

import cn.com.bgy.ifc.entity.po.repair.MaintenanceCompany;

public interface MaintenanceCompanyDao {
    int insert(MaintenanceCompany record);

    int insertSelective(MaintenanceCompany record);
}