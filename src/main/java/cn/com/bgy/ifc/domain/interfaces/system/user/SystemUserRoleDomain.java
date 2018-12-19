package cn.com.bgy.ifc.domain.interfaces.system.user;

import cn.com.bgy.ifc.entity.po.system.user.SystemUserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemUserRoleDomain {
    /**
     * 保存
     * @param systemUserRole
     * @return
     */
    int save(SystemUserRole systemUserRole);

    /**
     * 条件查询
     * @param systemUserRole
     * @return
     */
    List<SystemUserRole> searchByWhere(SystemUserRole systemUserRole);

    /**
     * 分页查询
     * @param page
     * @param systemUserRole
     * @return
     */
    PageInfo<SystemUserRole> searchByPage(Page page, SystemUserRole systemUserRole);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * id查找
     * @param id
     * @return
     */
    SystemUserRole findById(Long id);

    /**
     * 更新
     * @param systemUserRole
     * @return
     */
    int updateById(SystemUserRole systemUserRole);
}
