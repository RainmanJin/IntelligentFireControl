package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.CFireContents;

public interface CFireContentsDao {
    int insert(CFireContents record);

    int insertSelective(CFireContents record);
}