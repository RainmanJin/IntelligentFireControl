package cn.com.bgy.ifc.bgy.utils;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.basic.HttpVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:响应数据封装工具类
 * @date: 2018-12-12 09:24
 **/
public class ResponseUtil {



    /**
     *  获取数据页数
     * @param response
     * @param pageSize
     * @return
     */
    public static int getPageCount(JSONObject response,int pageSize){
        Integer recordCount=null;
        if (response != null) {
            JSONObject jsonObject = response.getJSONObject("data");
            if (jsonObject != null) {
                recordCount= jsonObject.getInteger("totalSize");
            }
        }
        int pageCount=0;
        // 总页数
        if(recordCount!=null){
            pageCount = recordCount % pageSize > 0 ? recordCount / pageSize + 1 : recordCount / pageSize;
        }
        return pageCount;
    }

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

    /**
     * @author: ZhangCheng
     * @description:根据总页数递增封装数据List
     * @param: [pageNo, pageSize, pageCount, config, reqUrl, oList, bgyUserVo, dataKey, listKey]
     * @return: java.util.List
     */
    public static List getResultByPage(int pageNo, int pageSize, int pageCount, ExternalInterfaceConfig config, String reqUrl, List oList, Object bgyUserVo, String dataKey, String listKey)throws Exception {
        int startPage = pageNo + 1;
        int newPage = pageNo + 1;
        for (int i = startPage; i <= pageCount; i++) {
            Map<String, Object> newData = new HashMap<>();
            newData.put("pageNo", newPage);
            newData.put("pageSize", pageSize);
            HttpVo httpVo2 = SignatureUtil.getHttpVo(config, reqUrl, newData);
            JSONObject newResponse = HttpHelper.httpPost(httpVo2.getUrl(), newData, httpVo2.getHeaderMap());
            getResultList(oList, bgyUserVo, newResponse, dataKey, listKey);
            newPage++;
        }
        return oList;
    }

    /**
     * @author: ZhangCheng
     * @description:增量接口调用
     * @param: [pageNo, pageSize, startTime, pageCount, config, reqUrl, oList, bgyUserVo, dataKey, listKey]
     * @return: java.util.List
     */
    public static List getIncResultByPage(int pageNo, int pageSize,String startTime, int pageCount, ExternalInterfaceConfig config, String reqUrl, List oList, Object bgyUserVo, String dataKey, String listKey)throws Exception {
        int startPage = pageNo + 1;
        int newPage = pageNo + 1;
        for (int i = startPage; i <= pageCount; i++) {
            Map<String, Object> newData = new HashMap<>();
            newData.put("startTime", startTime);
            newData.put("pageNo", newPage);
            newData.put("pageSize", pageSize);
            HttpVo httpVo2 = SignatureUtil.getHttpVo(config, reqUrl, newData);
            JSONObject newResponse = HttpHelper.httpPost(httpVo2.getUrl(), newData, httpVo2.getHeaderMap());
            getResultList(oList, bgyUserVo, newResponse, dataKey, listKey);
            newPage++;
        }
        return oList;
    }
}
