package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Information;

public interface InformationDao {
    int insert(Information record);

    int insertSelective(Information record);
}