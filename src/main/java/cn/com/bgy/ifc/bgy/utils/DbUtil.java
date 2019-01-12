package cn.com.bgy.ifc.bgy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: ZhangCheng
 * @description:1. ArrayList的底层保存数据还是采用数组Array的方式。
 * *                 所以，遍历访问数组的数据，最快的方式是采用数组的索引，相当于从内存中直接读取数据。
 * *                 因此，使用size效率最高。但是，在多线程时需要考虑并发操作的问题。 2.Map遍历，key,value
 * *                 EntrySet更优。如果是JDK8，使用Map.foreach方法。
 * @date: 2018-12-18 17:26
 **/

public class DbUtil {

    private static Logger logger = LoggerFactory.getLogger(DbUtil.class);

    /**
     * 添加实体list数据
     *
     * @param tableName 插入的数据库的表名
     * @param list      插入的实体list数据
     * @return 影响的行数
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static int insertByList(String tableName, List list) throws Exception {
        int size = list.size();
        List<Map<String, Object>> datas = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String, Object> valueMap = EntityUtil.entityToMap(list.get(i));
            datas.add(valueMap);
        }
        String executeName="INSERT INTO ";
        return insertAll(tableName,executeName, datas);
    }

    /**
     * 批量更新数据
     * @param tableName
     * @param list
     * @return
     * @throws Exception
     */
    public static int replaceAll(String tableName,List<Map<String, Object>> list)throws Exception{
        String executeName="REPLACE INTO ";
        int size = list.size();
        List<Map<String, Object>> datas = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<String,Object> newValueMap=new HashMap<>();
            Map<String, Object> valueMap = list.get(i);
            valueMap.forEach((key,value)->{
                newValueMap.put(EntityUtil.humpToLine(key),value);
            });
            datas.add(newValueMap);
        }
        return insertAll(tableName,executeName, datas);
    }

    /**
     * 分批次插入数据
     * @param tableName
     * @param list
     * @param addSize
     * @return
     * @throws Exception
     */
    public static int insertListByPage(String tableName, List list, int addSize) throws Exception {
        int listSize = list.size();
        int sumCount = 0;
        int cycleTimes = listSize % addSize > 0 ? (listSize / addSize) + 1 : listSize / addSize;
        for (int i = 0; i < cycleTimes; i++) {
            int size = (i + 1) * addSize > listSize ? listSize : (i + 1) * addSize;
            List newList = list.subList((i * addSize), size);
            int totalCount = insertByList(tableName, newList);
            if (totalCount != newList.size()) {
                break;
            }
            sumCount = sumCount + totalCount;
        }
        return sumCount;
    }

    /**
     * 执行数据库插入操作
     * @param tableName 要插入的数据库的表名
     * @param executeName 操作名称
     * @param data  插入数据表中key为列名和value为列对应的值的Map对象的List集合
     * @return 影响的行数
     * @throws Exception
     */
    public static int insertAll(String tableName,String executeName,List<Map<String, Object>> data) throws Exception {
        // 影响的行数
        int affectRowCount = -1;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //获取数据库连接
            connection = DbConnection.getConnection();
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
                //驼峰命名转下划线,根据数据库命名可自行更改
                columnSql.append(key);

                unknownMarkSql.append(i == 0 ? "" : ",");
                unknownMarkSql.append("?");
                i++;
            }
            // 开始拼插入的sql语句
            StringBuilder sql = new StringBuilder();
            sql.append(executeName);
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
            logger.error("JDBC批量添加数据异常:" , e);
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
