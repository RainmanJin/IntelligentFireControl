package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.vo.system.SystemRoleVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统角色
 * @date: 2018-12-26 17:57
 **/
public interface SystemRoleService extends BaseService<SystemRole> {

    PageInfo<SystemRole> queryListByPage(Page<SystemRole> page, SystemRoleVo systemRoleVo);

    /**
     * 批量更新角色菜单权限
     * @param roleId
     * @param list
     * @return
     */
    int insertRoleMenu(Long roleId,List<SystemMenu> list);
}
