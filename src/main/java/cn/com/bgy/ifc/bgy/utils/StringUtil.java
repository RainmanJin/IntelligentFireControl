package cn.com.bgy.ifc.bgy.utils;

/**
 * @Author huxin
 * @Date 2018/12/12 10:26
 * @Description 字符串工具类
 **/

public class StringUtil {
    /**
     * @Author huxin
     * @Description 判定String是否为null
     * @Date 2018/12/12 10:29
     */
    public static boolean isEmpty(String s) {
        if (null == s || "".equals(s) || "".equals(s.trim()) || "null".equalsIgnoreCase(s)|| "undefined".equalsIgnoreCase(s)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @Author huxin
     * @Description 判定String是否为null
     * @Date 2018/12/12 10:34
     */
    public static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean contains(String source,String target){
          if(source.indexOf(target) !=-1){
            return true;
          }else{
              return false;
          }
    }
}
