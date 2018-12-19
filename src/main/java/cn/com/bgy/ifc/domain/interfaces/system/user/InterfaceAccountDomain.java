package cn.com.bgy.ifc.domain.interfaces.system.user;

import cn.com.bgy.ifc.entity.po.system.user.InterfaceAccount;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface InterfaceAccountDomain {

    InterfaceAccount findById(Long id);

    int insert(InterfaceAccount interfaceaccount);

    int deleteById(Long id);
    /**
     * 逻辑删除用户接口（批量）
     * @param longs
     */
    void  deleteInterfaceAccount(Long[] longs);

    int update(InterfaceAccount interfaceAccount);
    /**
     * 分页
     * @param page
     * @param interfaceAccount
     * @return
     */
     PageInfo<InterfaceAccount> searchByWhere(Page page, InterfaceAccount interfaceAccount);
}