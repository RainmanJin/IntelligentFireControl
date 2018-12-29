package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.dao.system.SystemOperationLogDao;
import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.system.SystemOperationLogVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOperationLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统日志
 * @date: 2018-12-26 17:09
 **/
@Service
public class SystemOperationLogServiceImpl implements SystemOperationLogService {

    @Resource
    private SystemOperationLogDao systemOperationLogDao;

    /**
     * @author: ZhangCheng
     * @description:系统日志分页查询
     * @param: [page, systemOperationLogVo]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.system.SystemOperationLog>
     */
    @Override
    public PageInfo<SystemOperationLog> queryListByParam(Page<SystemOperationLog> page, SystemOperationLogVo systemOperationLogVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), "create_time DESC");
        List<SystemOperationLog> list= systemOperationLogDao.queryListByParam(systemOperationLogVo);
        return  new PageInfo<SystemOperationLog>(list);
    }

    /**
     * @author: ZhangCheng
     * @description:系统日志添加
     * @param: [systemOperationLog]
     * @return: int
     */
    @Override
    public int insertSystemLogInfo(SystemOperationLog systemOperationLog) {
        systemOperationLog.setCreateTime(new Date());
        systemOperationLog.setLogicRemove(false);
        return systemOperationLogDao.insertSelective(systemOperationLog);
    }
}
