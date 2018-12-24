package cn.com.bgy.ifc.dao.base;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:公用Dao层
 * @date: 2018-12-19 16:23
 **/
public interface BaseDao<T> {

    /**
     * 参数查询
     *
     * @param t
     * @return
     */
    List<T> queryListByParam(T t);

    /**
     * 根据Map参数查询
     *
     * @param map
     * @return
     */
    List<T> queryListByMap(Map<String, Object> map);

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 添加
     *
     * @param t
     * @return
     */
    int insertSelective(T t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 修改
     *
     * @param t
     * @return
     */
    int updateSelective(T t);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(List<Long> ids);


}
