package cn.com.bgy.ifc.domain.interfaces.system;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.BgyOrgVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemOrganizationDomain {
    /**
     * 分页
     * @param interfaceAccount
     * @return
     */
    PageInfo<SystemOrganization> searchByWhere(Page page, SystemOrganization interfaceAccount);

    /**
     * @author: ZhangCheng
     * @description:集成平台全量增加机构信息
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> saveBgyOrgList(List<BgyOrgVo> list,Long orgId );

    /**
     * @author: ZhangCheng
     * @description:集成平台增量增加机构信息
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> alterBgyOrgList(List<BgyOrgVo> list,Long orgId);

    /**
     * 根据当前登录用获取机构
     * @param userId
     * @return
     */
    SystemOrganization querySystemOrganizationByUserId(Long userId);
}
