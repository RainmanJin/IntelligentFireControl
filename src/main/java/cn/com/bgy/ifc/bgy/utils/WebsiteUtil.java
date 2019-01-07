package cn.com.bgy.ifc.bgy.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

    /**
     * @author: ZhangCheng
     * @description:处理下载文件中文名称乱码问题
     * @param: [request, name]
     * @return: java.lang.String
     */
    public static String getHeaderName(HttpServletRequest request,String name){
        try {
            if (request.getHeader("User-Agent").toLowerCase()
                    .indexOf("firefox") > 0) {
                // Firefox浏览器
                name = new String(name.getBytes("UTF-8"), "ISO8859-1");
            } else if (request.getHeader("User-Agent").toUpperCase()
                    .indexOf("MSIE") > 0) {
                // IE浏览器
                name = URLEncoder.encode(name, "UTF-8");
            } else if (request.getHeader("User-Agent").toUpperCase()
                    .indexOf("CHROME") > 0) {
                // 谷歌
                name = new String(name.getBytes("UTF-8"), "ISO8859-1");
            }
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return name;
    }
}
