package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.SystemOperationLogDao;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemLogDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.basic.SystemOperationLogVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * @Description 多条件查询日志信息（类型，时间范围：开始日期/结束日期）及分页
     * @Date 2018/12/6 14:51
     */
    @Override
    public PageInfo<SystemOperationLog> queryRequirementSytemLogInfo( Page<SystemOperationLog> page, Map<String,String> map) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemOperationLog> list= systemOperationLogDao.queryRequirementSytemLogInfo(map);
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
