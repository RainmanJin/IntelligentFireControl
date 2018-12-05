package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemRolePower;
import cn.com.bgy.ifc.entity.po.basic.SystemUserRole;

import java.util.List;

public interface SystemRolePowerDao {
    int insert(SystemRolePower record);

    int insertSelective(SystemRolePower record);

    SystemRolePower findById(Long id);

    List<SystemRolePower> searchByWhere(SystemRolePower record);

    int deleteById(Long id);

    int updateById(SystemRolePower record);
}