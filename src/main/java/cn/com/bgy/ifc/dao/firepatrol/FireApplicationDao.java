package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.FireApplication;

public interface FireApplicationDao {
    int insert(FireApplication record);

    int insertSelective(FireApplication record);
}