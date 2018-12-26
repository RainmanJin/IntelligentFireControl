package cn.com.bgy.ifc.dao.system;
import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemOrganizationDao extends BaseDao<SystemOrganization> {

    /**
     * @author: ZhangCheng
     * @description:
     * @param: [keywords]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.system.SystemOrganization>
     */
    List<SystemOrganization> queryListByPage(String keywords);

    /**
     * 根据当前登录用获取机构
     * @param userId
     * @return
     */
    SystemOrganization querySystemOrganizationByUserId(Long userId);
}