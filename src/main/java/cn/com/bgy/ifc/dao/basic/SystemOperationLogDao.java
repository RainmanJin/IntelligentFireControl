package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemOperationLogWithBLOBs;

public interface SystemOperationLogDao {
    int insert(SystemOperationLogWithBLOBs record);

    int insertSelective(SystemOperationLogWithBLOBs record);
}