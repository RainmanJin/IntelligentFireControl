package cn.com.bgy.ifc.bgy.aspect;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOperationLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: ZhangCheng
 * @description:方法结束日志
 * @date: 2018-12-12 17:27
 * <p>
 * 使用方式，在方法上使用@SystemLogAfterSave(type=1,description = "描述")
 * 需在方法后增加ResponseVO对象，便于添加日志信息
 * type类型参考SystemConstant.SystemLogType中枚举类型
 **/
@Aspect
@Component
public class SystemLogAfterAspect {

    @Autowired
    private SystemOperationLogService systemOperationLogService;

    /**
     * @author: ZhangCheng
     * @description:使用注解方式记录系统日志
     * @param: [joinPoint, result]
     * @return: void
     */
    @AfterReturning(returning = "result", pointcut = "@annotation(cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave)")
    public void save(JoinPoint joinPoint, ResponseVO<Object> result) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //方法如果存在这样的注释，则返回指定类型的元素的注释，否则为null。
        SystemLogAfterSave systemLogAfterSave = method.getAnnotation(SystemLogAfterSave.class);
        SystemOperationLog systemOperationLog = new SystemOperationLog();
        //joinPoint.
        if (systemLogAfterSave != null) {
            //注解上的类型
            systemOperationLog.setLogType(systemLogAfterSave.type());
            //注解上的描述
            systemOperationLog.setOperatorDescribe(systemLogAfterSave.description());
        }
        //获取操作完成后的信息
        if (null != result.getMsg()) {
            systemOperationLog.setOperatorContent(result.getMsg());
        }
        systemOperationLogService.insertSystemLogInfo(systemOperationLog);
    }
}
