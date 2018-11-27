package cn.com.bgy.ifc.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    /**	 * 配置拦截器，获取绝对路径	 */
    @Override	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BasePathInterceptor());
    }
}
