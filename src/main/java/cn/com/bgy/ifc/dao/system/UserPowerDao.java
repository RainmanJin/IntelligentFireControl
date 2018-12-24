package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.entity.po.system.SystemUserPower;

import java.util.List;

/**
 * 用户权限
 */
public interface UserPowerDao {
    /**
     * 查询用户权限列表
     * @param systemUserPower
     * @return
     */
    List<SystemUserPower> queryPageList(SystemUserPower systemUserPower);

    /**
     * 查询部门名称
     * @return
     */
    List<String> getDpartmentName();
}
