package cn.com.bgy.ifc.domain.impl.system.user;

import cn.com.bgy.ifc.dao.system.user.UserPowerDao;
import cn.com.bgy.ifc.domain.interfaces.system.user.UserPowerDomain;
import cn.com.bgy.ifc.entity.po.system.user.SystemUserPower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户权限
 */
@Service
public class UserPowerDomainImpl implements UserPowerDomain {
    @Resource
    private UserPowerDao userPowerDao;

    /**
     * 查询用户权限列表展示页面
     * @param systemUserPower
     * @return
     */
    @Override
    public PageInfo<SystemUserPower> queryPageList(Page page, SystemUserPower systemUserPower) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<SystemUserPower> modelPowerList = userPowerDao.queryPageList(systemUserPower);
        PageInfo<SystemUserPower> pageInfo = new PageInfo<>(modelPowerList);
        return pageInfo;
    }
    @Override
    public List<String> getDpartmentName() {
        return userPowerDao.getDpartmentName();
    }
}
