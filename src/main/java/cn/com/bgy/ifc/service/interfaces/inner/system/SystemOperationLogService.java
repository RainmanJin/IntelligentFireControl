package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.system.SystemOperationLogVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:系统日志
 * @date: 2018-12-26 17:08
 **/
public interface SystemOperationLogService {

     /**
      *
      * @param page
      * @param systemOperationLogVo
      * @return
      */
     PageInfo<SystemOperationLog> queryListByParam(Page<SystemOperationLog> page, SystemOperationLogVo systemOperationLogVo);

     /**
      *
      * @param systemOperationLog
      * @return
      */
     int insertSystemLogInfo(SystemOperationLog systemOperationLog);

     /**
      *
      * @param id
      * @return
      */
     SystemOperationLog findById(Long id);
}
