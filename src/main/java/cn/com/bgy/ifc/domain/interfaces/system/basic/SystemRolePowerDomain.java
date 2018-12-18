package cn.com.bgy.ifc.domain.interfaces.system.basic;

import cn.com.bgy.ifc.entity.po.system.basic.SystemRolePower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemRolePowerDomain {
    /**
     * 保存
     * @param systemRolePower
     * @return
     */
    int save(SystemRolePower systemRolePower);

    /**
     * 条件查询
     * @param systemRolePower
     * @return
     */
    List<SystemRolePower> searchByWhere(SystemRolePower systemRolePower);

    /**
     * 分页查询
     * @param page
     * @param systemRolePower
     * @return
     */
    PageInfo<SystemRolePower> searchByPage(Page page, SystemRolePower systemRolePower);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * id查找角色权限
     * @param id
     * @return
     */
    SystemRolePower findById(Long id);

    /**
     * 更新
     * @param systemRolePower
     * @return
     */
    int updateById(SystemRolePower systemRolePower);
}
