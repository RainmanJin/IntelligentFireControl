package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.basic.SystemOperationLogVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/6 10:36
 * @Description 系统日志domain
 **/

public interface SystemLogDomain {

    public PageInfo<SystemOperationLog> queryListByParam(Page<SystemOperationLog> page, SystemOperationLogVo systemOperationLogVo);

    public PageInfo<SystemOperationLog> queryRequirementSytemLogInfo( Page<SystemOperationLog> page, Map<String,String> map);

    public void addSystemLogInfo(SystemOperationLog systemOperationLog);

}
