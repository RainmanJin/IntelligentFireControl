package cn.com.bgy.ifc.dao.basic;

import java.util.List;
import java.util.Map;

public interface SystemOperationLogDao {
    int insert(SystemOperationLog record);

    int insertSelective(SystemOperationLog record);

    List<SystemOperationLog> querySystemLogInfo();

    List<SystemOperationLog> queryRequirementSytemLogInfo(Map<String,String> map);

    void addSystemLogInfo(SystemOperationLog record);
}