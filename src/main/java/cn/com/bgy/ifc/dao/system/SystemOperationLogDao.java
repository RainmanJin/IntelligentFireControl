package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.system.SystemOperationLogVo;

import java.util.List;
import java.util.Map;

public interface SystemOperationLogDao {
    int insert(SystemOperationLog record);

    int insertSelective(SystemOperationLog record);

    List<SystemOperationLog> queryListByParam(SystemOperationLogVo systemOperationLogVo);

}