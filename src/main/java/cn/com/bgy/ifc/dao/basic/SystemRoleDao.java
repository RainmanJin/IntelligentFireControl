package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemRole;

public interface SystemRoleDao {
    int insert(SystemRole record);

    int insertSelective(SystemRole record);
}