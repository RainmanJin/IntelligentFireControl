package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.ModelPower;
import cn.com.bgy.ifc.entity.po.basic.UserPower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserPowerDomain {
    /**
     * 查询用户权限列表
     * @param userPower
     * @return
     */
    PageInfo<UserPower> queryPageList(Page page, UserPower userPower);
    /**
     * 查询部门名称
     * @return
     */
    List<String> getDpartmentName();
}
