package cn.com.bgy.ifc.dao.system.user;

import cn.com.bgy.ifc.entity.po.system.user.SystemUserRole;

import java.util.List;

public interface SystemUserRoleDao {
    int insert(SystemUserRole record);

    int insertSelective(SystemUserRole record);

    int deleteById(Long id);

    SystemUserRole findById(Long id);

    List<SystemUserRole> searchByWhere(SystemUserRole record);

    int updateById(SystemUserRole record);


}