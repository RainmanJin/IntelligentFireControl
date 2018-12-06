package cn.com.bgy.ifc.bgy.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: ZhangCheng
 * @description:WebsiteUtil
 * @date: 2018-12-06 09:31
 **/
public class WebsiteUtil {

    /**
     * 判断请求是否是ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        String accept = request.getHeader("accept");
        if(accept != null && accept.indexOf("application/json") > -1 || (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)){
            return true;
        }
        return false;
    }
}
