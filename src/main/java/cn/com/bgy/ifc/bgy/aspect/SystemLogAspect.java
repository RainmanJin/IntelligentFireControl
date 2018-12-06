package cn.com.bgy.ifc.bgy.aspect;

import cn.com.bgy.ifc.bgy.annotation.SystemLogSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.entity.po.basic.SystemOperationLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author: ZhangCheng
 * @description:操作日志
 * @Aspect：采用AOP切面控制操作日志
 * @Component：让此类被Spring托管
 * @date: 2018-12-06 14:44
 *
 * 调用方式，在方法上使用@SystemLogSave(type="1",description = "描述")
 **/
@Aspect
@Component
public class SystemLogAspect {

  //  @Autowired
    //private SystemLogDo

    @Pointcut("@annotation(cn.com.bgy.ifc.bgy.annotation.SystemLogSave)")
    public void systemLogSave() {
    }

    @Before("systemLogSave()")
    public void save(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SystemLogSave systemLogSave = method.getAnnotation(SystemLogSave.class);
        SystemOperationLog systemOperationLog=new SystemOperationLog();
        if (systemLogSave != null) {
            //注解上的类型
            System.out.println("type:"+systemLogSave.type());

            //systemOperationLog.setLogType(systemLogSave.type());
            //注解上的描述
           // systemLogSave.description();
            systemOperationLog.setOperatorDescribe(systemLogSave.description());
        }
    }
}
