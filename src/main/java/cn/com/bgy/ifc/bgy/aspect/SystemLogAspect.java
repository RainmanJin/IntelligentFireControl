package cn.com.bgy.ifc.bgy.aspect;

import cn.com.bgy.ifc.bgy.annotation.SystemLogSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.utils.IpUtil;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOperationLogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author: ZhangCheng
 * @description:操作日志
 * @Aspect：采用AOP切面控制操作日志
 * @Component：让此类被Spring托管
 * @date: 2018-12-06 14:44
 * <p>
 * 调用方式，在方法上使用@SystemLogSave(type=SystemLogType.OPERATION_LOG,description = "描述",login=LoginState.IS_LOGIN)
 * type类型参考SystemLogType中枚举类型（type默认为操作日志）
 * login表示是否登录（login默认为已登录）
 * 注解不需要数据返回
 **/
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private SystemOperationLogService systemOperationLogService;

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
            systemOperationLog.setLogType(systemLogSave.type().getValue());
            //注解上的描述
            systemOperationLog.setOperatorDescribe(systemLogSave.description());
            //判断是否登录
            if (systemLogSave.login().getValue() == LoginState.IS_LOGIN.getValue()) {
                Account user = (Account) SecurityUtils.getSubject().getSession().getAttribute("user");
                if (user != null) {
                    systemOperationLog.setUserId(user.getId());
                    systemOperationLog.setUserName(user.getUserName());
                }
                //获取IP地址
                HttpServletRequest request = attributes.getRequest();
                String ip = IpUtil.getIpAddress(request);
                systemOperationLog.setIp(ip);
            }
        }

        systemOperationLogService.insertSystemLogInfo(systemOperationLog);
    }
}
