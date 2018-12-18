package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.SystemPowerDao;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemPowerDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemPower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统权限
 * @date: 2018-12-05 11:20
 **/
@Service
public class SystemPowerDomainImpl implements SystemPowerDomain {

    @Resource
    private SystemPowerDao systemPowerDao;


    @Override
    public PageInfo<SystemPower> queryListByPage(Page<SystemPower> page, SystemPower record) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemPower> list = systemPowerDao.queryListByParam(record);
        return new PageInfo<SystemPower>(list);
    }

    @Override
    public List<SystemPower> queryListByParam(SystemPower record) {
        return systemPowerDao.queryListByParam(record);
    }

    @Transactional
    @Override
    public int insert(SystemPower record) {
        record.setLogicRemove(false);
        return systemPowerDao.insert(record);
    }

    @Override
    public SystemPower findById(Long id) {
        return systemPowerDao.findById(id);
    }

    @Transactional
    @Override
    public int update(SystemPower record) {
        return update(record);
    }

    @Transactional
    @Override
    public int deleteById(Long id) {
        return systemPowerDao.deleteById(id);
    }

    @Override
    public List<SystemPower> queryListByUserId(Long userId) {
        return systemPowerDao.queryListByUserId(userId);
    }
}
