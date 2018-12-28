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

     PageInfo<SystemMenuVo> queryAllSystemMenuInfo(Page<SystemMenuVo> page, String keyWord);

    /**
     * 通过用户和类型获取菜单树
     * @param type
     * @param userId
     * @return
     */
     List<SystemMenu> findMenuTreeByType(int type , Long userId);

}
