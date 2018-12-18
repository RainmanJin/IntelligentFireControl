package cn.com.bgy.ifc.domain.interfaces.system.basic;
import cn.com.bgy.ifc.entity.po.system.basic.SystemOrganization;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface SystemOrganizationDomain {
    SystemOrganization findById(Long id);

    int insert(SystemOrganization systemOrganization);

    int deleteById(Long id);

    int update(SystemOrganization systemOrganization);
    /**
     * 分页
     * @param interfaceAccount
     * @return
     */
    PageInfo<SystemOrganization> searchByWhere(Page page, SystemOrganization interfaceAccount);
}
