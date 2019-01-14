package cn.com.bgy.ifc.bgy.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:List工具类
 * @date: 2018-12-20 19:08
 **/
public class ListUtil {

    public static void main(String[] args) {
        String id = "[a,b,c,d]";
        String[] arrayIds = id.split(",");
        String ids =  Joiner.on(",").join(arrayIds);
        //Joiner.on(",")
        System.out.println(ids);
    }

    /**
     * @author: ZhangCheng
     * @description:将ID字符串转换为List<Long></>
     * @param: [ids]
     * @return: java.util.List<java.lang.Long>
     */
    public static List<Long> getListId(String ids){
        //获取的id为批量时截取
        List<Long> list= JSON.parseArray(ids,Long.class);
        return list;
    }

    public static String getIdStr(List list){
        StringBuilder ids = new StringBuilder();
        int size=list.size();
        for(int i=0;i<size;i++){
            ids.append(i == 0 ? "" : ",");
            ids.append(list.get(i));
        }
        return ids.toString();
    }

    /**
     * @author: ZhangCheng
     * @description:List数据去重
     * @param: [list]
     * @return: java.util.List
     */
    public static List removeDuplicate(List list) {
        LinkedHashSet set = new LinkedHashSet<>(list.size());
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }
}
