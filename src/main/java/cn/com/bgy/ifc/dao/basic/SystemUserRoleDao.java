package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemUserRole;

public interface SystemUserRoleDao {
    int insert(SystemUserRole record);

    int insertSelective(SystemUserRole record);
}