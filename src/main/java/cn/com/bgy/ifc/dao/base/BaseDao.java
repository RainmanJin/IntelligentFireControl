package cn.com.bgy.ifc.dao.base;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:公用Dao层
 * @date: 2018-12-19 16:23
 **/
public interface BaseDao<T> {

    int insert(T t);

    int insertSelective(T t);

    int update(T t);

    int updateSelective(T t);

    List<T> queryListByParam(T t);
}
