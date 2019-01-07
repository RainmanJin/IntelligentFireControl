package cn.com.bgy.ifc.bgy.utils;

/**
 * @author: ZhangCheng
 * @description:异常信息处理
 * @date: 2019-01-07 18:27
 **/
public class ExceptionUtil {

    /**
     * @author: ZhangCheng
     * @description:处理异常信息，便于系统日志记录
     * @param: [message, e]
     * @return: java.lang.String
     */
    public static String getExceptionMsg(String message, Exception e){
        StackTraceElement stackTraceElement = e.getStackTrace()[0];
        String exString = message + e.getMessage() + "，详细信息：" + stackTraceElement + "，异常行数:" + stackTraceElement.getLineNumber();
        return exString;
    }
}
