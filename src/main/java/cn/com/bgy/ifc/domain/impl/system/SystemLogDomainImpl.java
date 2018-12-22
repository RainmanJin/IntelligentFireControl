package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.dao.system.SystemOperationLogDao;
import cn.com.bgy.ifc.domain.interfaces.system.SystemLogDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.system.basic.SystemOperationLogVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/6 10:36
 * @Description 系统日志domain实现层
 **/
@Service
public class SystemLogDomainImpl implements SystemLogDomain {
    @Resource
    SystemOperationLogDao systemOperationLogDao;

    /**
     * @author: ZhangCheng
     * @description:分页查询系统日志
     * @param: [page, param]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.basic.SystemOperationLog>
     */
    @Override
    public PageInfo<SystemOperationLog> queryListByParam(Page<SystemOperationLog> page, SystemOperationLogVo systemOperationLogVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemOperationLog> list= systemOperationLogDao.queryListByParam(systemOperationLogVo);
        return  new PageInfo<SystemOperationLog>(list);
    }

    /**
     * @Author huxin
     * @Description 日志增加
     * @Date 2018/12/6 18:24
     */
    @Override
    public void addSystemLogInfo(SystemOperationLog systemOperationLog) {
        systemOperationLog.setCreateTime(new Date());
        systemOperationLog.setLogicRemove(false);
        systemOperationLogDao.addSystemLogInfo(systemOperationLog);
    }

}
