package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemOrganization;

public interface SystemOrganizationDao {
    int insert(SystemOrganization record);

    int insertSelective(SystemOrganization record);
}