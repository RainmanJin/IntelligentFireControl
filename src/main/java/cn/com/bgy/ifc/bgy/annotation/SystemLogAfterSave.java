package cn.com.bgy.ifc.bgy.annotation;

import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: ZhangCheng
 * @description:方法结束后添加系统日志注解
 * @date: 2018-12-12 17:24
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLogAfterSave {

    //日志类型（type类型参考SystemLogType中枚举类型）
    SystemLogType type() default SystemLogType.OPERATION_LOG;

    //日志描述
    String description() default "";

    //判断是否已登录
    LoginState login() default LoginState.IS_LOGIN;
}
