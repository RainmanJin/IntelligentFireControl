package cn.com.bgy.ifc.bgy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:响应数据封装工具类
 * @date: 2018-12-12 09:24
 **/
public class ResponseUtil {

    /**
     * @author: ZhangCheng
     * @description:响应数据封装结果集
     * @param: [dataList, dataObj, response, dataKey, listKey]
     * @return: java.util.List
     */
    public static List getResultList(List dataList, Object dataObj, JSONObject response, String dataKey, String listKey) {
        if (response != null) {
            //data作为key获取JSONObject
            JSONObject jsonObject = response.getJSONObject(dataKey);
            if (jsonObject != null) {
                List<Object> objList = jsonObject.getJSONArray(listKey);
                if (objList.size() > 0) {
                    for (Object object : objList) {
                        String jsonStr = JSONObject.toJSONString(object);
                        //JSON转换为object
                        dataList.add(JSON.parseObject(jsonStr, dataObj.getClass()));
                    }
                }
            }
        }
        return dataList;
    }

    /**
     * @author: ZhangCheng
     * @description:转换ListMap
     * @param: [response, dataKey, listKey]
     * @return: java.util.List<java.util.Map < java.lang.String , java.lang.Object>>
     */
    public static List<Map<String, Object>> getResultListMap(JSONObject response, String dataKey, String listKey) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (response != null) {
            //data作为key获取JSONObject
            JSONObject jsonObject = response.getJSONObject(dataKey);
            if (jsonObject != null) {
                List<Object> objList = jsonObject.getJSONArray(listKey);
                if (objList.size() > 0) {
                    for (Object object : objList) {
                        String jsonStr = JSONObject.toJSONString(object);
                        Map<String, Object> params = JSONObject.parseObject(jsonStr, new TypeReference<Map<String, Object>>() {
                        });
                        mapList.add(params);
                    }
                }
            }
        }
        return mapList;
    }
}
