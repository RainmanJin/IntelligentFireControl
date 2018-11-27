package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.User;

public interface UserDao {
    int insert(User record);

    int insertSelective(User record);
}