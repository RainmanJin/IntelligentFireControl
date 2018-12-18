package cn.com.bgy.ifc.dao.system.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMenuDao {
    public int insert(SystemMenu record);

    public int insertSelective(SystemMenu record);

    public int addSystemMenuInfo(SystemMenu systemMenu);

    public List<SystemMenu> queryAllSystemMenuInfo(@Param("keyWord") String keyWord);

    public SystemMenu queryOneSystemMenuInfo(Long id);

    public int updateSystemMenuInfo(SystemMenu systemMenu);

    public int deleteSystemMenuInfo(Long id);

    public int deleteListSystemMenuInfo(Long[] id);

    List<SystemMenu> findMenuByUser(Long userId);

    List<SystemMenu> findMenuByUserAndParentId(@Param("parentId") Long parentId,@Param("userId") Long userId);
}