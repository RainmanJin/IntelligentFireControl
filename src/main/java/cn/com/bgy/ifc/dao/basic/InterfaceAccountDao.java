package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.InterfaceAccount;

public interface InterfaceAccountDao {
    int insert(InterfaceAccount record);

    int insertSelective(InterfaceAccount record);
}