package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemMenu;

import java.util.List;
import java.util.Map;

public interface SystemMenuDao {
    public int insert(SystemMenu record);

    public int insertSelective(SystemMenu record);

    public int addSystemMenuInfo(SystemMenu systemMenu);

    public List<SystemMenu> queryAllSystemMenuInfo(SystemMenu systemMenu);

    public List<SystemMenu> queryKeyWordSystemMenuInfo(String keyWord);

    public SystemMenu queryOneSystemMenuInfo(Long id);

    public int updateSystemMenuInfo(SystemMenu systemMenu);

    public int deleteSystemMenuInfo(Long id);

    public int deleteListSystemMenuInfo(Long[] id);

    List<SystemMenu> findMenuByUser(Long userId);
}