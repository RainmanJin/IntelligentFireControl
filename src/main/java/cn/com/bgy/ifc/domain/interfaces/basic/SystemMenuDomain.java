package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;

import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/5 10:27
 * @Description 系统菜单Service层
 **/

public interface SystemMenuDomain {
    /**
     * @Author huxin
     * @Description 查询所有系统菜单一级菜单，及二级菜单
     * @Date 2018/12/5 10:04
     * @Param []
     * @return cn.com.bgy.ifc.entity.po.basic.SystemMenu
     */
    public List<SystemMenu> queryAllSystemMenuInfo();
    /**
     * @Author huxin
     * @Description 根据ID查询系统菜单 单条信息
     * @Date 2018/12/5 17:00
     * @Param []
     * @return java.util.List<cn.com.bgy.ifc.entity.po.basic.SystemMenu>
     */
    public SystemMenu queryOneSystemMenuInfo(Long id);
    /**
     * @Author huxin
     * @Description 查询关键字搜索
     * @Date 2018/12/5 18:13
     * @Param [keyWord]
     * @return java.util.List<cn.com.bgy.ifc.entity.po.basic.SystemMenu>
     */
    public List<SystemMenu> queryKeyWordSystemMenuInfo(String keyWord);

    /**
     * @Author huxin
     * @Description 增加菜单,包括一二级菜单
     * @Date 2018/12/5 10:06
     * @Param [systemMenu]
     * @return void
     */
    public ResponseVO addSystemMenuInfo( SystemMenu systemMenu);
    /**
     * @Author huxin
     * @Description 根据ID修改菜单，包括一二级信息
     * @Date 2018/12/5 10:09
     * @Param [systemMenu]
     * @return void
     */
    public ResponseVO updateSystemMenuInfo(SystemMenu systemMenu);
    /**
     * @Author huxin
     * @Description 根据ID删除一条菜单，包括一二级菜单
     * @Date 2018/12/5 10:11
     * @Param [id]
     * @return void
     */
    public ResponseVO deleteSystemMenuInfo(Long id);
    /**
     * @Author huxin
     * @Description 根据ID批量删除菜单，包括一二级菜单
     * @Date 2018/12/5 10:13
     * @Param [id]
     * @return void
     */
    public ResponseVO deleteListSystemMenuInfo(Long[] id);
}
