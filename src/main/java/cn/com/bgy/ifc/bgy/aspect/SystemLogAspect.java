package cn.com.bgy.ifc.bgy.aspect;

import cn.com.bgy.ifc.bgy.annotation.SystemLogSave;
import cn.com.bgy.ifc.domain.interfaces.system.SystemLogDomain;
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

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:操作日志
 * @Aspect：采用AOP切面控制操作日志
 * @Component：让此类被Spring托管
 * @date: 2018-12-06 14:44
 * <p>
 * 调用方式，在方法上使用@SystemLogSave(type=1,description = "描述")
 * type类型参考SystemConstant.SystemLogType中枚举类型
 **/
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private SystemLogDomain systemLogDomain;

    @Pointcut("@annotation(cn.com.bgy.ifc.bgy.annotation.SystemLogSave)")
    public void systemLogSave() {
    }

    /**
     * @author: ZhangCheng
     * @description:根据方法上的注解添加系统日志
     * @param: [joinPoint]
     * @return: void
     */
    @Before("systemLogSave()")
    public void save(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //方法如果存在这样的注释，则返回指定类型的元素的注释，否则为null。
        SystemLogSave systemLogSave = method.getAnnotation(SystemLogSave.class);
        SystemOperationLog systemOperationLog = new SystemOperationLog();
        if (systemLogSave != null) {
            //注解上的类型
            systemOperationLog.setLogType(systemLogSave.type());
            //注解上的描述
            systemOperationLog.setOperatorDescribe(systemLogSave.description());
        }
        systemOperationLog.setCreateTime(new Date());
        systemOperationLog.setLogicRemove(false);
        systemLogDomain.addSystemLogInfo(systemOperationLog);
    }
}
