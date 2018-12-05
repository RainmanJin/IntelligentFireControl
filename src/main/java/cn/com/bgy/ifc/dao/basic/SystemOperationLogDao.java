package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemOperationLog;

public interface SystemOperationLogDao {
    int insert(SystemOperationLog record);

    int insertSelective(SystemOperationLog record);
}