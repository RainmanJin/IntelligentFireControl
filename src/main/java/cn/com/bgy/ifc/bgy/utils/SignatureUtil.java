package cn.com.bgy.ifc.bgy.utils;


import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.basic.HttpVo;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author: ZhangCheng
 * @description:签名工具类
 * @date: 2018-12-07 15:09
 **/
public class SignatureUtil {

    /**
     * @author: ZhangCheng
     * @description:请求参数封装
     * @param: [config, reqUrl, data]
     * @return: cn.com.bgy.ifc.entity.vo.basic.HttpVo
     */
    public static HttpVo getHttpVo(ExternalInterfaceConfig config,String reqUrl,Map<String, Object> data){
        HttpVo httpVo=new HttpVo();
        String url = config.getUrl() + reqUrl;
        String account = config.getAccount();
        String signKey = config.getSignKey();
        String timestampStr = SignatureUtil.timestampStr();
        String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
        //集成平台HTTP头部需要数据
        Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
        httpVo.setUrl(url);
        httpVo.setHeaderMap(headerMap);
        return httpVo;
    }

    /**
     * @author: ZhangCheng
     * @description:获取时间戳字符串
     * @param: []
     * @return: java.lang.String
     */
    public static String timestampStr() {
        long timestamp = new Date().getTime();
        return String.valueOf(timestamp);
    }

    /**
     * @author: ZhangCheng
     * @description:实现签名加密
     * @param: [timestampStr, signKey, postData]
     * timestampStr：时间戳字符串，
     * SignKey：集成平台提供的第三方平台账号专用密码,与account对应
     * postData：请求DATA的JSON字符串
     * @return: java.lang.String 加密后的全大写密文
     */
    public static String getBgySignature(String timestampStr, String signKey, Map<String, Object> data) {
        String postData = JSON.toJSONString(data);
        String signatureStr = timestampStr + signKey + postData;
        char[] charArray = signatureStr.toCharArray();
        //数组排序
        Arrays.sort(charArray);
        signatureStr = new String(charArray);
        // 对密码进行加密
        return getBgyMd5(signatureStr).toUpperCase();
    }

    /**
     * @author: ZhangCheng
     * @description:封装集成平台请求头部
     * @param: [timestampStr, signature, account]
     * @return: java.util.Map<java.lang.String , java.lang.Object>
     */
    public static Map<String, Object> getBgyHeader(String timestampStr, String signature, String account) {
        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put("timestamp", timestampStr);
        headerMap.put("signature", signature);
        headerMap.put("account", account);
        return headerMap;
    }

    /**
     * @author: ZhangCheng
     * @description:MD5加密明文
     * @param: [plaintext]
     * @return: java.lang.String
     */
    public static String getBgyMd5(String plaintext) {
        return new Md5Hash(plaintext).toString();
    }

}