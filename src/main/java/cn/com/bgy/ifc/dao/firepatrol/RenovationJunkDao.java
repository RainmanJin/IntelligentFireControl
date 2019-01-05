package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.RenovationJunk;

public interface RenovationJunkDao {
    int insert(RenovationJunk record);

    int insertSelective(RenovationJunk record);
}