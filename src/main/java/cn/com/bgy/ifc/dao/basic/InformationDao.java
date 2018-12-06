package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Information;

public interface InformationDao {
    Information findById(Long id);

    int insert(Information information);

    int deleteById(Long id);

    int update(Information information);
}