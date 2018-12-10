package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author huxin
 * @Date 2018/12/5 10:27
 * @Description 系统菜单Service层
 **/

public interface SystemMenuDomain {

    public PageInfo<SystemMenu> queryAllSystemMenuInfo( Page<SystemMenu> page, SystemMenu systemMenu);

    public SystemMenu queryOneSystemMenuInfo(Long id);

    public List<SystemMenu> queryKeyWordSystemMenuInfo(String keyWord);


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
}
