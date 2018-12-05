package cn.com.bgy.ifc.domain.interfaces.basic;
import cn.com.bgy.ifc.entity.po.basic.SystemOrganization;
public interface SystemOrganizationDomain {
    SystemOrganization findById(Long id);

    int insert(SystemOrganization systemOrganization);

    int deleteById(Long id);

    int update(SystemOrganization systemOrganization);
}
