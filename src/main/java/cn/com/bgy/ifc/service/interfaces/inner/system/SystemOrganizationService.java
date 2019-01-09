package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-26 10:53
 **/
public interface SystemOrganizationService extends BaseService<SystemOrganization> {

    List<SystemOrganization> queryList(String keywords);

    /**
     * 机构分页查询
     * @param page
     * @param keywords
     * @return
     */
    PageInfo<SystemOrganization>  queryListByPage(Page page, String keywords);

    /**
     * 获取机构管理员
     * @param roleValue
     * @param orgId
     * @return
     */
    List<SelectVo> getOrgAdmin(String roleValue, Long orgId);
}
