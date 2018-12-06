package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Information;

import java.util.List;

public interface InformationDao {
    Information findById(Long id);

    int insert(Information information);

    int deleteById(Long id);

    int update(Information information);

    List<Information> searchByWhere(Information information);
}