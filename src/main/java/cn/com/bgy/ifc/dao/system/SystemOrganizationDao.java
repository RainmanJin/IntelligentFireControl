package cn.com.bgy.ifc.dao.system;
import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;

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

    /**
     * 根据当前登录用获取机构
     * @param userId
     * @return
     */
    SystemOrganization querySystemOrganizationByUserId(Long userId);
}