package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统菜单
 * @date: 2018-12-28 09:47
 **/
public interface SystemMenuService extends BaseService<SystemMenu> {

    /**
     * 分页查询
     * @param page
     * @param keyWord
     * @return
     */
    PageInfo<SystemMenuVo> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord);

    /**
     * 通过用户和类型获取菜单树
     * @param type
     * @param userId
     * @return
     */
    List<SystemMenu> findMenuTreeByType(int type , Long userId);

    /**
     * 参数查询
     * @param systemMenu
     * @return
     */
    List<SystemMenu> queryListByParam(SystemMenu systemMenu);

    /**
     * 获取上级菜单
     * @return
     */
    List<SelectVo> getParentMenu();

    /**
     * 根据角色ID查询菜单权限
     * @param roleId
     * @return
     */
    List<SystemMenu> queryRolePermission(Long roleId);

}
