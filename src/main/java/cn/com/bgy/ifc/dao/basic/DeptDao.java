package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Dept;

public interface DeptDao {
    int insert(Dept record);

    int insertSelective(Dept record);
}