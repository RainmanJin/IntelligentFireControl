package cn.com.bgy.ifc.dao.base;

import org.apache.ibatis.annotations.Param;

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
     * 根据Object参数查询
     *
     * @param object
     * @return
     */
    List<T> queryListByObj(Object object);

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
     * 批量修改数据
     * @param list
     * @return
     */
    int updateBatch(List<T> list);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteBatch(@Param("list")List<Long> ids);

    /**
     * 单条删除
     *
     * @param id
     * @return
     */
    int deleteById(Long id);

}
