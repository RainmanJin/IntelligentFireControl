package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMenuDao extends BaseDao<SystemMenu> {

     List<SystemMenu> queryAllSystemMenuInfo(@Param("keyWord") String keyWord);

    List<SystemMenu> findMenuListByType(@Param("type") int type,@Param("userId") Long userId);

    List<SystemMenu>  queryParentMenu();

}