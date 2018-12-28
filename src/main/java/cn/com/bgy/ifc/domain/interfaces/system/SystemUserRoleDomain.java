package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemUserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface SystemUserRoleDomain {
    /**
     * 保存
     * @param systemUserRole
     * @return
     */
    int save(SystemUserRole systemUserRole);

    /**
     * 条件查询
     * @param account
     * @return
     */
    List<Map<String,Object>> searchByWhere(Account account);

    /**
     * 分页查询
     * @param page
     * @param account
     * @return
     */
    PageInfo<Map<String,Object>>  searchByPage(Page page, Account account);

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
