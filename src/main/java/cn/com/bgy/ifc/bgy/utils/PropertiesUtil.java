package cn.com.bgy.ifc.bgy.utils;

import cn.com.bgy.ifc.config.api.JdbcConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ZhangCheng
 * @description:用于静态字段获取application.yml的配置文件中的值
 * @date: 2018-12-18 20:01
 **/

@Configuration
public class PropertiesUtil {

    @Value("${spring.datasource.driver-class-name}")
    private  String driver;

    @Value("${spring.datasource.jdbc-url}")
    private  String url;

    @Value("${spring.datasource.username}")
    private  String username;

    @Value("${spring.datasource.password}")
    private  String password;

    @Bean
    public int initProperties() {
        JdbcConfig.setDriver(driver);
        JdbcConfig.setUrl(url);
        JdbcConfig.setUsername(username);
        JdbcConfig.setPassword(password);
        return 0;
    }

}
