package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Information;

public interface InformationDomain {
    Information findById(Long id);

    int insert(Information information);

    int deleteById(Long id);

    int update(Information information);
}
