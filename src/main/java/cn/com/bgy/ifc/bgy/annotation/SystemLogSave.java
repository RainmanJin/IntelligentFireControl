package cn.com.bgy.ifc.bgy.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: ZhangCheng
 * @description:保存系统日志注解
 * @date: 2018-12-06 14:58
 * @Target 注解
 * 功能：指明了修饰的这个注解的使用范围，即被描述的注解可以用在哪里。
 * @Retention 注解
 * 功能：指明修饰的注解的生存周期，即会保留到哪个阶段。
 * @Documented 注解
 * 功能：指明修饰的注解，可以被例如javadoc此类的工具文档化，只负责标记，没有成员取值。
 **/

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLogSave {
    //日志类型
    String type() default "";

    //日志描述
    String description() default "";
}
