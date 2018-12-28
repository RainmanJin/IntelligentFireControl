package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemUserRole;

import java.util.List;
import java.util.Map;

public interface SystemUserRoleDao {
    int insert(SystemUserRole record);

    int insertSelective(SystemUserRole record);

    int deleteById(Long id);

    SystemUserRole findById(Long id);

    List<Map<String,Object>> searchByWhere(Account record);

    int updateById(SystemUserRole record);


}