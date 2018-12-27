package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-26 10:53
 **/
public interface SystemOrganizationService extends BaseService<SystemOrganization> {

    PageInfo<SystemOrganization>  queryListByPage(Page page, String keywords);
}
