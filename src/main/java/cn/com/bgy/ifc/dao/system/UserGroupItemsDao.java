package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.UserGroupItems;

import java.util.List;

public interface UserGroupItemsDao extends BaseDao<UserGroupItems> {

    UserGroupItems findByUserId(Long userId);

    //根据用户ID查询返回区域ID
    List<Long> queryRegionIdByUserId(Long userId);

    //根据用户ID查询返回项目ID
    List<Long> queryProjectIdByUserId(Long userId);


}