package cn.com.bgy.ifc.bgy.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:List工具类
 * @date: 2018-12-20 19:08
 **/
public class ListUtil {

    /**
     * @author: ZhangCheng
     * @description:将ID字符串转换为List<Long></>
     * @param: [ids]
     * @return: java.util.List<java.lang.Long>
     */
    public static List<Long> getListId(String ids){
        //获取的id为批量时截取
        String[] stringIds = ids.split(",");
        List<Long> list = new ArrayList<>();
        for (String string : stringIds) {
            list.add(Long.valueOf(string));
        }
        return list;
    }
}
