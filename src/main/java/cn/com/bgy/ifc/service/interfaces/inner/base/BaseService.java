package cn.com.bgy.ifc.service.interfaces.inner.base;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:公用Service层
 * @date: 2018-12-26 10:56
 **/
public interface BaseService<T> {

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
