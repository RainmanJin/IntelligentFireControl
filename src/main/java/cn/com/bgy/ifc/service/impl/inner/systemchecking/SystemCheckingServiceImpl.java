package cn.com.bgy.ifc.service.impl.inner.systemchecking;

import cn.com.bgy.ifc.dao.systemchecking.SystemCheckingDao;
import cn.com.bgy.ifc.entity.po.systemchecking.SystemChecking;
import cn.com.bgy.ifc.entity.vo.systemchecking.SystemCheckingVo;
import cn.com.bgy.ifc.service.interfaces.inner.systemchecking.SystemCheckingService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统巡检体检
 * @date: 2019-02-13 17:34
 **/
@Service
public class SystemCheckingServiceImpl implements SystemCheckingService {

    @Resource
    private SystemCheckingDao systemCheckingDao;

    @Override
    public PageInfo<SystemChecking> queryListByPage(Page page, SystemCheckingVo systemCheckingVo) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemChecking> list =systemCheckingDao.queryListByParam(systemCheckingVo);
        PageInfo<SystemChecking> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
