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
    public static final String SUCCESS = "000";
    /**
     * 业务报错
     */
    public static final String ERROR = "001";
    /**
     * 程序异常
     */
    public static final String EXCEPTION = "503";

    /**
     * 未授权
     */
    public static final String WITHOUTPERMISSION = "401";

    /**
     * 未登陆
     */
    public static final String WITHOUTLOTIN = "606";
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
    /**
     * 未授权
     * @return
     */
    public static <T> ResponseVO<T> withoutPermission(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.WITHOUTPERMISSION).setMsg("抱歉，您暂时没有权限进行该操作");
    }


    /**
     * 未登陆
     * @return
     */
    public static <T> ResponseVO<T> withoutLogin(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.WITHOUTLOTIN).setMsg("抱歉，您暂时没有权限进行该操作");
    }

    /**
     * @author: ZhangCheng
     * @description:添加成功提示信息
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<T>
     */
    public static <T> ResponseVO<T> addSuccess(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.SUCCESS).setMsg("添加成功");
    }
    /**
     * @author: ZhangCheng
     * @description:修改成功提示信息
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<T>
     */
    public static <T> ResponseVO<T> editSuccess(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.SUCCESS).setMsg("修改成功");
    }

    /**
     * @author: ZhangCheng
     * @description:删除成功提示信息
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<T>
     */
    public static <T> ResponseVO<T> deleteSuccess(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.SUCCESS).setMsg("删除成功");
    }

    /**
     * @author: ZhangCheng
     * @description:添加失败提示信息
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<T>
     */
    public static <T> ResponseVO<T> addError(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.ERROR).setMsg("添加失败！");
    }
    /**
     * @author: ZhangCheng
     * @description:修改失败提示信息
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<T>
     */
    public static <T> ResponseVO<T> editError(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.ERROR).setMsg("修改失败！");
    }

    /**
     * @author: ZhangCheng
     * @description:删除失败提示信息
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<T>
     */
    public static <T> ResponseVO<T> deleteError(){
        ResponseVO<T> responseVO = new ResponseVO<T>();
        return responseVO.setCode(ResponseVO.ERROR).setMsg("删除失败！");
    }
}
