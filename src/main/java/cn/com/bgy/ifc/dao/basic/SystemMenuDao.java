package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemMenu;

public interface SystemMenuDao {
    int insert(SystemMenu record);

    int insertSelective(SystemMenu record);
}