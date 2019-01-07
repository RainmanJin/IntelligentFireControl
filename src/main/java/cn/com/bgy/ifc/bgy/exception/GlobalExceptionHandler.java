package cn.com.bgy.ifc.bgy.exception;

import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOperationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: ZhangCheng
 * @description:全局异常处理 用于处理在请求映射和请求处理过程中抛出的异常的类
 * @date: 2019-01-05 12:17
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private SystemOperationLogService systemOperationLogService;

    /**
     * 系统异常
     *
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseVO<Object> exceptionHandler(Exception exception) {
        return logAndResult(ResponseVO.EXCEPTION, "服务器发生异常，请联系管理员！", exception);
    }

    /**
     * 业务异常
     *
     * @param businessException
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseVO<Object> businessException(BusinessException businessException) {
        return logAndResult(ResponseVO.ERROR, "服务器发生异常，请联系管理员！", businessException);
    }

    /**
     * @author: ZhangCheng
     * @description:异常处理
     * @param: [errCode, errMsg, e]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    private ResponseVO<Object> logAndResult(String errCode, String errMsg, Exception e) {
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String message = "系统出现异常,异常信息：";
        //业务异常
        if (errCode == ResponseVO.ERROR) {
            message = "系统出现业务异常,异常信息：";
        }
        String exString = message + e.getMessage() + "，详细信息：" + stackTraceElement + "，异常行数:" + stackTraceElement.getLineNumber();
        SystemOperationLog systemOperationLog = new SystemOperationLog();
        systemOperationLog.setLogType(SystemLogType.ERROR_LOG.getValue());
        systemOperationLog.setOperatorDescribe("系统异常");
        systemOperationLog.setOperatorContent(exString);
        systemOperationLogService.insertSystemLogInfo(systemOperationLog);
        ResponseVO<Object> result = new ResponseVO<>();
        result.setCode(errCode);
        result.setMsg(errMsg);
        logger.error("系统出现异常,异常信息：", e);
        return result;
    }
}
