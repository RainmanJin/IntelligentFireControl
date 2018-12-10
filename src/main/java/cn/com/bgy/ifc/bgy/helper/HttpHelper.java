package cn.com.bgy.ifc.bgy.helper;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
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
     * HTTP GET请求
     *
     * @param url 请求地址
     * @return 返回JSON
     * @throws Exception
     */
    public static JSONObject httpGet(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpGet.setConfig(requestConfig);
        try {
            response = httpClient.execute(httpGet, new BasicHttpContext());
            // 检验返回码，判断是否成功，HttpStatus.SC_OK=200
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                logger.info("GET请求失败,请求校验码：" + response.getStatusLine().getStatusCode() + "，请求地址：" + url);
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
            logger.info("GET请求异常,请求地址：" + url + "，异常信息：" + e.getMessage());
        } finally {
            if (response != null)
                try {
                    response.close();
                } catch (IOException e) {
                    logger.info("IOException：" + e.getMessage());
                }
        }
        return null;
    }

    /**
     * HTTP POST请求
     *
     * @param url  请求地址
     * @param data 请求参数
     * @return 返回JSON
     * @throws Exception
     */
    public static JSONObject httpPost(String url, Object data, Map<String, Object> headerMap) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json");
        if (null != headerMap && headerMap.size() > 0) {
            // 遍历Map中的Key和Value，那么推荐使用的、效率最高的方式EntrySet
            Iterator<Entry<String, Object>> iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, Object> entry = iterator.next();
                httpPost.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        try {
            //JSON数据格式请求
            StringEntity requestEntity = new StringEntity(JSON.toJSONString(data), CHARSET);
            httpPost.setEntity(requestEntity);

            response = httpClient.execute(httpPost, new BasicHttpContext());
            // 检验返回码，判断是否成功，HttpStatus.SC_OK=200
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                logger.info("POST请求失败,请求校验码：" + response.getStatusLine().getStatusCode() + "，请求地址：" + url);
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
            logger.info("POST请求异常,请求地址：" + url + "，异常信息：" + e.getMessage());
        } finally {
            if (response != null)
                try {
                    response.close();
                } catch (IOException e) {
                    logger.info("IOException：" + e.getMessage());
                }
        }
        return null;
    }

}
