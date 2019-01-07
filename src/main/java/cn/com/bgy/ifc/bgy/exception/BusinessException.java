package cn.com.bgy.ifc.bgy.exception;

/**
 * @author: ZhangCheng
 * @description:业务处理异常，便于系统记录异常日志
 * @date: 2019-01-07 12:03
 **/
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, Throwable cause,
                            boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
