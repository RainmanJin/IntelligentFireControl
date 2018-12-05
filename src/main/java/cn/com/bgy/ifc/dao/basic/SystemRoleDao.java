package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.po.basic.SystemPower;
import cn.com.bgy.ifc.entity.po.basic.SystemRole;

import java.util.List;

public interface SystemRoleDao {


    List<SystemRole> queryAllList();

    List<SystemRole> queryListByParam(SystemRole record);

    SystemRole findById(Long id);

    int insert(SystemRole record);

    int insertSelective(SystemRole record);

    int update(SystemRole record);

    int deleteById(Long id);
}