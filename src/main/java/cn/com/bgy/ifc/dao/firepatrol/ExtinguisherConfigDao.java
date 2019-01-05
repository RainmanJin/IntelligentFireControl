package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.ExtinguisherConfig;

public interface ExtinguisherConfigDao {
    int insert(ExtinguisherConfig record);

    int insertSelective(ExtinguisherConfig record);
}