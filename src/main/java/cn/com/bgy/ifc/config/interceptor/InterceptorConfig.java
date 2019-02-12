package cn.com.bgy.ifc.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableConfigurationProperties(ApplicationProperties.class)
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private ApplicationProperties applicationProperties;

    public InterceptorConfig() {
    }

    /**	 * 配置拦截器，获取绝对路径	 */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BasePathInterceptor());
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:cn.com.bgy.ifc/static/");
        System.out.println(applicationProperties.file.getStaticAccessPath());
        registry.addResourceHandler(applicationProperties.file.getStaticAccessPath()).addResourceLocations("file:"+applicationProperties.file.getUploadFolder());
    }
}
