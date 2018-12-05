package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemPower;
import cn.com.bgy.ifc.entity.po.basic.SystemRolePower;

import java.util.List;

public interface SystemPowerDao {

    List<SystemPower> queryAllList();

    List<SystemPower> queryListByParam(SystemPower record);

    SystemPower findById(Long id);

    int insert(SystemPower record);

    int insertSelective(SystemPower record);

    int update(SystemPower record);

    int deleteById(Long id);
}