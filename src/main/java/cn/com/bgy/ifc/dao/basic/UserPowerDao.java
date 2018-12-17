package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.UserPower;

import java.util.List;

/**
 * 用户权限
 */
public interface UserPowerDao {
    /**
     * 查询用户权限列表
     * @param userPower
     * @return
     */
    List<UserPower> queryPageList(UserPower userPower);

    /**
     * 查询部门名称
     * @return
     */
    List<String> getDpartmentName();
}
