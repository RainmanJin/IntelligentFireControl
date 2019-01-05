package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.InterfaceAccount;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InterfaceAccountDomain {

    InterfaceAccount findById(Long id);

    int insert(InterfaceAccount interfaceaccount);

    int deleteById(Long id);
    /**
     * 逻辑删除用户接口（批量）
     * @param ids
     */
    void  deleteInterfaceAccount(List<Long> ids);

    int update(InterfaceAccount interfaceAccount);
    /**
     * 分页
     * @param page
     * @param interfaceAccount
     * @return
     */
     PageInfo<InterfaceAccount> searchByWhere(Page page, InterfaceAccount interfaceAccount);

}