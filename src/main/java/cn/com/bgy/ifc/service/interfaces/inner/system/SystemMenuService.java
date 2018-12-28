package cn.com.bgy.ifc.service.interfaces.inner.system;

import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import cn.com.bgy.ifc.service.interfaces.inner.base.BaseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统菜单
 * @date: 2018-12-28 09:47
 **/
public interface SystemMenuService extends BaseService<SystemMenu> {

    /**
     * @author: ZhangCheng
     * @description:分页查询
     * @param: [page, keyWord]
     * @return: com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.vo.system.SystemMenuVo>
     */
    PageInfo<SystemMenuVo> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord);

    /**
     * @author: ZhangCheng
     * @description:通过用户和类型获取菜单树
     * @param: [type, userId]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.system.SystemMenu>
     */
    List<SystemMenu> findMenuTreeByType(int type , Long userId);
}
