package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.UserPowerDao;
import cn.com.bgy.ifc.domain.interfaces.basic.UserPowerDomain;
import cn.com.bgy.ifc.entity.po.basic.UserPower;
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
     * @param userPower
     * @return
     */
    @Override
    public PageInfo<UserPower> queryPageList(Page page, UserPower userPower) {
        page = PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getOrderBy());
        List<UserPower> modelPowerList = userPowerDao.queryPageList(userPower);
        PageInfo<UserPower> pageInfo = new PageInfo<>(modelPowerList);
        return pageInfo;
    }
    @Override
    public List<String> getDpartmentName() {
        return userPowerDao.getDpartmentName();
    }
}
