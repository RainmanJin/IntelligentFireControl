package cn.com.bgy.ifc.bgy.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author: ZhangCheng
 * @description:Http请求封装 使用HttpClient和httpCore
 * @date: 2018-12-06 16:51
 **/
public class HttpHelper {

    private static Logger logger = LoggerFactory.getLogger(HttpHelper.class);

    //字符集
    private static final String CHARSET = "UTF-8";

    /**
     * @author: ZhangCheng
     * @description:HTTP GET请求封装
     * @param: [url]
     * `url 请求地址
     * @return: com.alibaba.fastjson.JSONObject 返回JSON
     */
    public static JSONObject httpGet(String url, Map<String, Object> headerMap) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        return httpRequestBase(httpGet, headerMap);
    }

    /**
     * @author: ZhangCheng
     * @description:HTTP DELETE请求封装
     * @param: [url, headerMap]
     * @return: com.alibaba.fastjson.JSONObject
     */
    public static JSONObject httpDelete(String url, Map<String, Object> headerMap) throws Exception {
        HttpDelete httpDelete = new HttpDelete(url);
        return httpRequestBase(httpDelete, headerMap);
    }

    /**
     * @author: ZhangCheng
     * @description:HTTP POST请求封装
     * @param: [url, data, headerMap]
     * url  请求地址
     * data 请求参数
     * headerMap 请求头部
     * @return: com.alibaba.fastjson.JSONObject 返回JSON
     */
    public static JSONObject httpPost(String url, Object data, Map<String, Object> headerMap) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        return httpBase(httpPost, data, headerMap);
    }

    /**
     * @author: ZhangCheng
     * @description:HTTP PUT请求封装
     * @param: [url, data, headerMap]
     * url  请求地址
     * data 请求参数
     * headerMap 请求头部
     * @return: com.alibaba.fastjson.JSONObject
     */
    public static JSONObject httpPut(String url, Object data, Map<String, Object> headerMap) throws Exception {
        HttpPut httpPut = new HttpPut(url);
        return httpBase(httpPut, data, headerMap);
    }

    public static JSONObject httpRequestBase(HttpRequestBase httpRequestBase, Map<String, Object> headerMap) {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpRequestBase.setConfig(requestConfig);
        httpRequestBase.addHeader("Content-Type", "application/json");
        if (null != headerMap && headerMap.size() > 0) {
            Iterator<Entry<String, Object>> iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> entry = iterator.next();
                httpRequestBase.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        try {

            response = httpClient.execute(httpRequestBase, new BasicHttpContext());
            // 检验返回码，判断是否成功，HttpStatus.SC_OK=200
            int httpStatusCode = response.getStatusLine().getStatusCode();
            if (httpStatusCode != HttpStatus.SC_OK) {
                logger.info(httpRequestBase.getMethod() + "请求失败,请求校验码：" + httpStatusCode + "，请求地址：" + httpRequestBase.getURI().getPath());
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, CHARSET);
                //数据转换为JSON
                JSONObject result = JSON.parseObject(resultStr);
                return result;
            }
        } catch (IOException e) {
            logger.info(httpRequestBase.getMethod() + "请求异常,请求地址：" + httpRequestBase.getURI().getPath() + "，异常信息：" + e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.info("IOException：" + e.getMessage());
                }
            }
        }
        return null;
    }

    /**
     * @author: ZhangCheng
     * @description:PUT请求和POST请求封装
     * @param: [httpBase, data, headerMap]
     * @return: com.alibaba.fastjson.JSONObject
     */
    public static JSONObject httpBase(HttpEntityEnclosingRequestBase httpBase, Object data, Map<String, Object> headerMap) throws Exception {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpBase.setConfig(requestConfig);
        httpBase.addHeader("Content-Type", "application/json");
        if (null != headerMap && headerMap.size() > 0) {
            Iterator<Entry<String, Object>> iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> entry = iterator.next();
                httpBase.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        try {
            //JSON数据格式请求
            StringEntity requestEntity = new StringEntity(JSON.toJSONString(data), CHARSET);
            httpBase.setEntity(requestEntity);

            response = httpClient.execute(httpBase, new BasicHttpContext());
            // 检验返回码，判断是否成功，HttpStatus.SC_OK=200
            int httpStatusCode = response.getStatusLine().getStatusCode();
            if (httpStatusCode != HttpStatus.SC_OK) {
                logger.info(httpBase.getMethod() + "请求失败,请求校验码：" + httpStatusCode + "，请求地址：" + httpBase.getURI().getPath());
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String resultStr = EntityUtils.toString(entity, CHARSET);
                //数据转换为JSON
                JSONObject result = JSON.parseObject(resultStr);
                return result;
            }
        } catch (IOException e) {
            logger.info(httpBase.getMethod() + "请求异常,请求地址：" + httpBase.getURI().getPath() + "，异常信息：" + e.getMessage());
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.info("IOException：" + e.getMessage());
                }
            }
        }
        return null;
    }

}
