package cn.com.bgy.ifc.bgy.aspect;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.utils.IpUtil;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOperationLogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author: ZhangCheng
 * @description:方法结束日志
 * @Aspect：采用AOP切面控制操作日志
 * @Component：让此类被Spring托管
 * @date: 2018-12-12 17:27
 * <p>
 * 使用方式，在方法上使用@SystemLogAfterSave(type=SystemLogType.OPERATION_LOG,description = "描述",login=LoginState.IS_LOGIN)
 * type类型参考SystemLogType中枚举类型（type默认为操作日志）
 * login表示是否登录（login默认为已登录）
 * 需在方法后增加ResponseVO对象，便于添加日志信息
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
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //方法如果存在这样的注释，则返回指定类型的元素的注释，否则为null。
        SystemLogAfterSave systemLogAfterSave = method.getAnnotation(SystemLogAfterSave.class);
        SystemOperationLog systemOperationLog = new SystemOperationLog();
        if (systemLogAfterSave != null) {
            int type = systemLogAfterSave.type().getValue();
            //注解上的类型
            systemOperationLog.setLogType(type);
            //注解上的描述
            systemOperationLog.setOperatorDescribe(systemLogAfterSave.description());
            if (null != result.getMsg()) {
                systemOperationLog.setOperatorContent(result.getMsg());
            }
            //操作日志和登录日志记录成功后的
            if (type == SystemLogType.OPERATION_LOG.getValue() || type == SystemLogType.LOGON_LOG.getValue()) {
                //获取操作完成后的信息
                if (result.getCode() == ResponseVO.SUCCESS) {
                    HttpServletRequest request = attributes.getRequest();
                    getLog(systemOperationLog,request);
                    systemOperationLogService.insertSystemLogInfo(systemOperationLog);
                }
            } else {
                //判断是否登录
                if (systemLogAfterSave.login().getValue().equals( LoginState.IS_LOGIN.getValue())) {
                    HttpServletRequest request = attributes.getRequest();
                    getLog(systemOperationLog,request);
                }
                systemOperationLogService.insertSystemLogInfo(systemOperationLog);
            }
        }
    }

    private SystemOperationLog getLog(SystemOperationLog systemOperationLog,HttpServletRequest request){
        Account user = (Account) SecurityUtils.getSubject().getSession().getAttribute("user");
        if (user != null) {
            systemOperationLog.setUserId(user.getId());
            systemOperationLog.setUserName(user.getUserName());
        }
        String ip = IpUtil.getIpAddress(request);
        systemOperationLog.setIp(ip);
        return systemOperationLog;
    }
}
