package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemRole;
import cn.com.bgy.ifc.entity.po.projects.QueryBena;

import java.util.List;

public interface SystemRoleDao {


    List<SystemRole> queryAllList(QueryBena queryBena);

    List<SystemRole> queryListByParam(SystemRole record);

    SystemRole findById(Long id);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    int updateRole(SystemRole record);

    int deleteById(Long id);

    int deleteRole(List<Long> list);

    List<SystemRole> queryRoleType();

    List<SystemRole> queryConditionSystemRole( QueryBena queryBena );
}