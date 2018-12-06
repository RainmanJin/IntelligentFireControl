package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Information;
import cn.com.bgy.ifc.entity.po.basic.InterfaceAccount;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface InterfaceAccountDomain {
    InterfaceAccount findById(Long id);

    int insert(InterfaceAccount interfaceAccount);

    int deleteById(Long id);

    int update(InterfaceAccount interfaceAccount);
    /**
     * 分页
     * @param interfaceAccount
     * @return
     */

    PageInfo<InterfaceAccount> searchByWhere(Page page, InterfaceAccount interfaceAccount);
}
