package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.SystemMenuVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/5 10:27
 * @Description 系统菜单Service层
 **/

public interface SystemMenuDomain {

    public PageInfo<SystemMenuVo> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord);

    public SystemMenu queryOneSystemMenuInfo(Long id);

    public ResponseVO addSystemMenuInfo( SystemMenu systemMenu);

    public ResponseVO updateSystemMenuInfo(SystemMenu systemMenu);

    public ResponseVO deleteSystemMenuInfo(Long id);

    public ResponseVO deleteListSystemMenuInfo(Long[] id);

    /**
     * 通过用户id查找访问权限菜单
     * @param userId
     * @return
     */
    public List<SystemMenu> findMenuByUser(Long userId);

    /**
     * 根据用户名查询菜单树
     * @param userId
     * @return
     */
    public Map<String,Object> findTree(Long userId);

    /**
     * 通过用户id查找访问权限菜单
     * @param userId,parentId
     * @return
     */
    public List<SystemMenu> findMenuByUserAndParentId(Long parentId , Long userId);

    /**
     * 根据父级id查询用户子菜单
     * @param parentId
     * @param userId
     * @return
     */
    public Map<String,Object> findTwoAndThreeUserMenuTree(Long parentId , Long userId);

}
