package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemPower;

public interface SystemPowerDao {
    int insert(SystemPower record);

    int insertSelective(SystemPower record);
}