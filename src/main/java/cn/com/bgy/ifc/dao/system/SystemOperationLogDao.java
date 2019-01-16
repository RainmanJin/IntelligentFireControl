package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.system.SystemOperationLogVo;

import java.util.List;
import java.util.Map;

public interface SystemOperationLogDao extends BaseDao<SystemOperationLog> {

    /**
     *
     * @param systemOperationLogVo
     * @return
     */
    List<SystemOperationLog> queryListByParam(SystemOperationLogVo systemOperationLogVo);


}