package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.SystemUserPower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserPowerDomain {
    /**
     * 查询用户权限列表
     * @param systemUserPower
     * @return
     */
    PageInfo<SystemUserPower> queryPageList(Page page, SystemUserPower systemUserPower);
    /**
     * 查询部门名称
     * @return
     */
    List<String> getDpartmentName();
}
