package cn.com.bgy.ifc.bgy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CopyUtil {

    /**
     * @author: ZhangCheng
     * @description:List<PO>转List<Vo>
     * @param: [list, dataObj]
     * @return: java.util.List
     */
    public static List convertList(final List list, final Object dataObj) {
        List<Object> resultList = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String jsonStr = JSONObject.toJSONString(list.get(i));
            resultList.add(JSON.parseObject(jsonStr, dataObj.getClass()));
        }
        return resultList;
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static void copyProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

}
