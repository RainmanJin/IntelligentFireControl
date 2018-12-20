package cn.com.bgy.ifc.dao.system.basic;
import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.basic.SystemOrganization;

import java.util.List;

public interface SystemOrganizationDao extends BaseDao<SystemOrganization> {

    int deleteById(Long id);
    /**
     * 逻辑删除机构（批量）
     * @param longs
     */
    void  deleteInterSystemOrganization(Long[] longs);

    /**
     * 分页
     * @param interfaceAccount
     * @return
     */
    List<SystemOrganization> searchByWhere(SystemOrganization interfaceAccount);
}