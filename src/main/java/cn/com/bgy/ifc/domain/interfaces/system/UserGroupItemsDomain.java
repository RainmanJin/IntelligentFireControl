package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.system.UserGroup;
import cn.com.bgy.ifc.entity.po.system.UserGroupItems;

import java.util.List;
import java.util.Map;

public interface UserGroupItemsDomain extends BaseDomain<UserGroupItems> {
    /**
     * 参数查询
     *
     * @param t
     * @return
     */
    List<UserGroupItems> queryListByParam(UserGroupItems t);

    /**
     * 根据Map参数查询
     *
     * @param map
     * @return
     */
    List<UserGroupItems> queryListByMap(Map<String, Object> map);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    UserGroupItems findById(Long id);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insert(UserGroupItems t);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insertSelective(UserGroupItems t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    public int update(UserGroupItems t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    public int updateSelective(UserGroupItems t);
}