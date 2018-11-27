package cn.com.bgy.ifc.entity.vo;

import java.io.Serializable;

/**
 * 展示层返回对象
 * @param <T>
 */
public class ResponseVO<T> implements Serializable {
    /**
     * 成功
     */
    public static final String SUCCESS = "0";
    /**
     * 业务报错
     */
    public static final String ERROR = "1";
    /**
     * 程序异常
     */
    public static final String EXCEPTION = "-1";
    /**
     * 状态码
     */
    private String code;
    /**
     * 消息（错误信息）
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public String getCode() {
        return code;
    }
    public ResponseVO<T> setCode(String code) {
        this.code = code;
        return this;
    }
    public String getMsg() {
        return msg;
    }
    public ResponseVO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }
    public T getData() {
        return data;
    }
    public ResponseVO<T> setData(T data) {
        this.data = data;
        return this;
    }

    /**
     * 默认创建方法
     * @return
     */
    public static <T> ResponseVO<T> success(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.SUCCESS);
    }

    /**
     * 默认抛出异常
     * @return
     */
    public static <T> ResponseVO<T> exception(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.EXCEPTION).setMsg("服务器发生异常，请联系管理员！");
    }

    /**
     * 默认错误
     * @return
     */
    public static <T> ResponseVO<T> error(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.ERROR);
    }


}
