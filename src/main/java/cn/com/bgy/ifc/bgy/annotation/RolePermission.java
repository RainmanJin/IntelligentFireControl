package cn.com.bgy.ifc.bgy.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: ZhangCheng
 * @description:权限控制注解
 * @date: 2019-01-28 17:06
 *
 * 说明：使用方式，在Controller类上加上此注解，BasePathInterceptor上则会进行拦截
 * @Target
 **/
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RolePermission {

}
