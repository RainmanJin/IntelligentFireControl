package cn.com.bgy.ifc.bgy.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

/**
 * @author: ZhangCheng
 * @description:方法结束后添加系统日志注解
 * @date: 2018-12-12 17:24
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface  SystemLogAfterSave {

    //日志类型（type类型参考SystemConstant.SystemLogType中枚举类型）
    int type() default 1;

    //日志描述
    String description() default "";
}
