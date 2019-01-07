package cn.com.bgy.ifc.config.api;

/**
 * @author: ZhangCheng
 * @description:JDBC配置参数Config
 * @date: 2018-12-18 20:08
 **/
public class JdbcConfig {

    private static String driver;

    private static String url;

    private static String username;

    private static String password;

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        JdbcConfig.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        JdbcConfig.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        JdbcConfig.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        JdbcConfig.password = password;
    }
}
