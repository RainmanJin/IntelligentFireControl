package cn.com.bgy.ifc.dao.system.basic;

import cn.com.bgy.ifc.entity.po.system.basic.SystemPower;

import java.util.List;

public interface SystemPowerDao {

    List<SystemPower> queryAllList();

    List<SystemPower> queryListByParam(SystemPower record);

    SystemPower findById(Long id);

    int insert(SystemPower record);

    int insertSelective(SystemPower record);

    int update(SystemPower record);

    int deleteById(Long id);

    List<SystemPower> queryListByUserId(Long userId);
}