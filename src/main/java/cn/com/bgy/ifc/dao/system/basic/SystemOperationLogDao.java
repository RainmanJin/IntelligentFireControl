package cn.com.bgy.ifc.dao.system.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.system.basic.SystemOperationLogVo;

import java.util.List;
import java.util.Map;

public interface SystemOperationLogDao {
    int insert(SystemOperationLog record);

    int insertSelective(SystemOperationLog record);

    List<SystemOperationLog> queryListByParam(SystemOperationLogVo systemOperationLogVo);

    List<SystemOperationLog> queryRequirementSytemLogInfo(Map<String,String> map);

    void addSystemLogInfo(SystemOperationLog record);
}