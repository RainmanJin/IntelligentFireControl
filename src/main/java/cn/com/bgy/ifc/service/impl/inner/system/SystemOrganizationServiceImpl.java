package cn.com.bgy.ifc.service.impl.inner.system;

import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.dao.system.SystemOrganizationDao;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOrganizationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:机构管理
 * @date: 2018-12-26 10:53
 **/
@Service
public class SystemOrganizationServiceImpl implements SystemOrganizationService {

    @Resource
    private SystemOrganizationDao systemOrganizationDao;

    @Override
    public SystemOrganization findById(Long id) {
        return systemOrganizationDao.findById(id);
    }

    @Override
    public int insert(SystemOrganization systemOrganization) {
        systemOrganization.setState(SystemConstant.EnableState.ENABLE.getValue());
        systemOrganization.setCreateTime(new Date());
        systemOrganization.setLogicRemove(false);
        return systemOrganizationDao.insert(systemOrganization);
    }

    @Override
    public int insertSelective(SystemOrganization systemOrganization) {
        systemOrganization.setState(SystemConstant.EnableState.ENABLE.getValue());
        systemOrganization.setCreateTime(new Date());
        systemOrganization.setLogicRemove(false);
        return systemOrganizationDao.insertSelective(systemOrganization);
    }

    @Override
    public int update(SystemOrganization systemOrganization) {
        systemOrganization.setCreateTime(new Date());
        return systemOrganizationDao.update(systemOrganization);
    }

    @Override
    public int updateSelective(SystemOrganization systemOrganization) {
        systemOrganization.setCreateTime(new Date());
        return systemOrganizationDao.updateSelective(systemOrganization);
    }

    @Override
    public int deleteBatch(List<Long> ids) {
        return systemOrganizationDao.deleteBatch(ids);
    }

    @Override
    public PageInfo<SystemOrganization> queryListByPage(Page page, String keywords) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemOrganization> list = systemOrganizationDao.queryListByPage(keywords);
        PageInfo<SystemOrganization> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
