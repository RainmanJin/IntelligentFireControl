package cn.com.bgy.ifc.domain.interfaces.system.basic;
import cn.com.bgy.ifc.entity.po.system.basic.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyOrgVo;
import cn.com.bgy.ifc.entity.vo.projects.BgyUserVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemOrganizationDomain {
    SystemOrganization findById(Long id);

    int insert(SystemOrganization systemOrganization);

    int deleteById(Long id);
    /**
     * 逻辑删除机构（批量）
     * @param longs
     */
    void  deleteInterSystemOrganization(Long[] longs);

    int update(SystemOrganization systemOrganization);
    /**
     * 分页
     * @param interfaceAccount
     * @return
     */
    PageInfo<SystemOrganization> searchByWhere(Page page, SystemOrganization interfaceAccount);

    /**
     * 集成平台全量增加机构信息
     * @param list
     * @return
     */
    ResponseVO<Object> saveBgyOrgList(List<BgyOrgVo> list,Long orgId );

    /**
     * 集成平台增量增加机构信息
     * @param list
     * @return
     */
    ResponseVO<Object> alterBgyOrgList(List<BgyOrgVo> list,Long orgId);

    /**
     * 根据当前登录用获取机构
     * @param userId
     * @return
     */
    SystemOrganization querySystemOrganizationByUserId(Long userId);
}
