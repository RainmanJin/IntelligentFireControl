package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.system.Groups;

import java.util.List;
import java.util.Map;

public interface GroupsDomain extends BaseDomain<Groups> {
    /**
     * 参数查询
     *
     * @param t
     * @return
     */
    List<Groups> queryListByParam(Groups t);

    /**
     * 根据Map参数查询
     *
     * @param map
     * @return
     */
    List<Groups> queryListByMap(Map<String, Object> map);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    Groups findById(Long id);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insert(Groups t);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insertSelective(Groups t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    public int update(Groups t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    public int updateSelective(Groups t);



}