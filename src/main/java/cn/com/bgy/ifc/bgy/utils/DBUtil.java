package cn.com.bgy.ifc.bgy.utils;

import cn.com.bgy.ifc.config.api.JDBCConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

/**
 * @author: ZhangCheng
 * @description:1. ArrayList的底层保存数据还是采用数组Array的方式。
 * *                 所以，遍历访问数组的数据，最快的方式是采用数组的索引，相当于从内存中直接读取数据。
 * *                 因此，使用size效率最高。但是，在多线程时需要考虑并发操作的问题。 2.Map遍历，key,value
 * *                 EntrySet更优。
 * @date: 2018-12-18 17:26
 **/

public class DBUtil {

    private static Logger logger = LoggerFactory.getLogger(DBUtil.class);

    /**
     * 添加实体list数据
     *
     * @param tableName
     *            插入的数据库的表名
     * @param list
     *            插入的实体list数据
     * @return 影响的行数
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static int insertByList(String tableName, List list)  throws Exception{
        int size=list.size();
        List<Map<String, Object>> datas=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String, Object> valueMap = EntityUtil.entityToMap(list.get(i));
            datas.add(valueMap);
        }
        return insertAll(tableName, datas);
    }



    /**
     * 执行数据库插入操作
     *
     * @param data      插入数据表中key为列名和value为列对应的值的Map对象的List集合
     * @param tableName 要插入的数据库的表名
     * @return 影响的行数
     * @throws SQLException SQL异常
     */
    public static int insertAll(String tableName, List<Map<String, Object>> data) throws Exception {
        // 影响的行数
        int affectRowCount = -1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 加载驱动
            Class.forName(JDBCConfig.getDriver());
            //从数据库连接池中获取数据库连接
            connection = DriverManager.getConnection(JDBCConfig.getUrl(), JDBCConfig.getUsername(), JDBCConfig.getPassword());

            Map<String, Object> valueMap = data.get(0);
            // 获取数据库插入的Map的键值对的值
            Set<String> keySet = valueMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            // 要插入的字段sql，其实就是用key拼起来的
            StringBuilder columnSql = new StringBuilder();
            // 要插入的字段值，其实就是？
            StringBuilder unknownMarkSql = new StringBuilder();
            Object[] keys = new Object[valueMap.size()];
            int i = 0;
            while (iterator.hasNext()) {
                String key = iterator.next();
                keys[i] = key;
                columnSql.append(i == 0 ? "" : ",");
                columnSql.append(key);

                unknownMarkSql.append(i == 0 ? "" : ",");
                unknownMarkSql.append("?");
                i++;
            }
            // 开始拼插入的sql语句
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT  INTO ");
            sql.append(tableName);
            sql.append(" (");
            sql.append(columnSql);
            sql.append(" )  VALUES (");
            sql.append(unknownMarkSql);
            sql.append(" )");

            // 执行SQL预编译
            preparedStatement = connection.prepareStatement(sql.toString());
            // 设置不自动提交，以便于在出现异常的时候数据库回滚
            connection.setAutoCommit(false);
            for (int j = 0; j < data.size(); j++) {
                for (int k = 0; k < keys.length; k++) {
                    preparedStatement.setObject(k + 1, data.get(j).get(keys[k]));
                }
                preparedStatement.addBatch();
            }
            int[] arr = preparedStatement.executeBatch();
            //所有命令执行完之后再提交事务
            connection.commit();
            affectRowCount = arr.length;
        } catch (Exception e) {
            if (connection != null) {
                connection.rollback();
            }
            logger.error("JDBC批量添加数据异常:"+e);
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return affectRowCount;
    }
}
