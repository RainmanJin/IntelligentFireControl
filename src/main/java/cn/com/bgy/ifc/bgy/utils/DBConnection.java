package cn.com.bgy.ifc.bgy.utils;

import cn.com.bgy.ifc.config.api.JDBCConfig;
import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: ZhangCheng
 * @description:获取数据库连接
 * @date: 2018-12-25 11:44
 **/
public class DBConnection {

    /**
     * 获取数据库对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        //不能定义为static让程序共享这一个Connection
        Connection connection =null;
        try {
        // 加载驱动
        Class.forName(JDBCConfig.getDriver());
        //获取数据库连接
        connection = DriverManager.getConnection(JDBCConfig.getUrl(), JDBCConfig.getUsername(), JDBCConfig.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
