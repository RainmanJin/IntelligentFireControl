package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.system.Groups;
import cn.com.bgy.ifc.entity.po.system.UserGroup;
import cn.com.bgy.ifc.entity.vo.system.GroupsVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface UserGroupDomain extends BaseDomain<UserGroup> {
    /**
     * 参数查询
     *
     * @param t
     * @return
     */
    List<UserGroup> queryListByParam(UserGroup t);

    /**
     * 根据Map参数查询
     *
     * @param map
     * @return
     */
    List<UserGroup> queryListByMap(Map<String, Object> map);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    UserGroup findById(Object id);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insert(UserGroup t);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insertSelective(UserGroup t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    public int update(UserGroup t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    public int updateSelective(UserGroup t);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    public int deleteBatch( List<Object> ids);

    public PageInfo<Map<String,Object>> searchByPage(Page<Map<String,Object>> page, GroupsVo groupsVo);
}