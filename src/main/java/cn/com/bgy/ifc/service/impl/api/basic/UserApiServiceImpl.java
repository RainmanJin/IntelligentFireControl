package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.exception.GlobalHandlerExceptionResolver;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.api.basic.UserApiService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserApiServiceImpl implements UserApiService {

    private static Logger logger = LoggerFactory.getLogger(UserApiServiceImpl.class);

    /**
     * @author: ZhangCheng
     * @description:集成平台验证登录用户
     * @param: [telephone, password]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> obtainBgyUserLogin(String telephone, String password) {
        try {
            String url = "http://47.107.20.19:9002/integration/api/third/user/login";
            String account = "fire-fighting";
            String signKey = "C1CF1733-1C64-4F6C-9138-6F968A1BBE9B";
            SignatureUtil signatureUtil=new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求数据
            Map<String, Object> data = new HashMap<>();
            //加密明文密码
            String cipherText = SignatureUtil.getBgyMd5(password);
            data.put("telephone", telephone);
            data.put("password", cipherText);
            String jsonString = JSON.toJSONString(data);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, jsonString);
            //HTTP头部需要数据
            Map<String, Object> headerMap = new HashMap<>();
            headerMap.put("timestamp", timestampStr);
            headerMap.put("signature", signature);
            headerMap.put("account", account);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPost(url, data, headerMap);
            if (response != null) {
                //data作为key获取JSONObject
                // statusCode
                String statusCode = response.getString("statusCode");
                if (!statusCode.equals("200")) {
                    String info = response.getString("info");
                    return ResponseVO.error().setMsg(info);
                }
                JSONObject jsonObject = response.getJSONObject("data");
                if (jsonObject != null) {
                    Integer userId = jsonObject.getInteger("userId");
                    return ResponseVO.success().setData(userId);
                }
            }
        } catch (Exception e) {
            logger.error("集成平台验证登录用户接口请求异常：" + e.getMessage());
        }
        return ResponseVO.success().setData(null);
    }

    /**
     * @author: ZhangCheng
     * @description:集成平台修改用户密码
     * @param: [telephone, password]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> obtainBgyUpdatePass(String telephone, String password) {
        try {
            String url = "http://47.107.20.19:9002/integration/api/third/user/updatePwd";
            String account = "fire-fighting";
            String signKey = "C1CF1733-1C64-4F6C-9138-6F968A1BBE9B";
            SignatureUtil signatureUtil=new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求数据
            Map<String, Object> data = new HashMap<>();
            //加密明文密码
            String cipherText = SignatureUtil.getBgyMd5(password);
            data.put("telephone", telephone);
            data.put("password", cipherText);
            String jsonString = JSON.toJSONString(data);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, jsonString);
        } catch (Exception e) {
            logger.error("集成平台修改用户密码接口请求异常：" + e.getMessage());
        }
        return null;
    }

    @Override
    public void obtainBgyUser() {
        try {
            String url = "http://47.107.20.19:9002/integration/api/third/user/getUserList";
            String account = "fire-fighting";
            String signKey = "C1CF1733-1C64-4F6C-9138-6F968A1BBE9B";
            SignatureUtil signatureUtil=new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求包结构体
            Map<String, Object> data = new HashMap<>();
            data.put("pageNo", 1);
            data.put("pageSize", 10);
            String jsonString = JSON.toJSONString(data);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, jsonString);
            //HTTP头部需要数据
            Map<String, Object> headerMap = new HashMap<>();
            headerMap.put("timestamp", timestampStr);
            headerMap.put("signature", signature);
            headerMap.put("account", account);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPost(url, data, headerMap);
            List<Map<String, Object>> mapList = new ArrayList<>();
            if (response != null) {
                //data作为key获取JSONObject
                JSONObject jsonObject = response.getJSONObject("data");
                if (jsonObject != null) {
                    List<Object> dataList = jsonObject.getJSONArray("list");
                    for (Object object : dataList) {
                        String jsonStr = JSONObject.toJSONString(object);
                        Map<String, Object> params = JSONObject.parseObject(jsonStr, new TypeReference<Map<String, Object>>() {
                        });
                        mapList.add(params);
                    }
                }
                System.out.println("mapList:" + mapList);
            }
        } catch (Exception e) {
            logger.error("获取集成平台用户列表接口请求异常：" + e.getMessage());
        }
    }

    @Override
    public void obtainBgyUserIncrement() {
        try {
            String url = "http://47.107.20.19:9002/integration/api/third/user/getUserList";
            String account = "fire-fighting";
            String signKey = "C1CF1733-1C64-4F6C-9138-6F968A1BBE9B";
            SignatureUtil signatureUtil=new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求包结构体
            Map<String, Object> data = new HashMap<>();
            data.put("pageNo", 1);
            data.put("pageSize", 10);
            String jsonString = JSON.toJSONString(data);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, jsonString);
            //HTTP头部需要数据
            Map<String, Object> headerMap = new HashMap<>();
            headerMap.put("timestamp", timestampStr);
            headerMap.put("signature", signature);
            headerMap.put("account", account);
        } catch (Exception e) {
            logger.error("请求接口异常：" + e.getMessage());
        }
    }

    @Override
    public void obtainBgyUserPermission() {
        try {
            String url = "http://47.107.20.19:9002/integration/api/third/user/getUserPermission";
            String account = "fire-fighting";
            String signKey = "C1CF1733-1C64-4F6C-9138-6F968A1BBE9B";
            SignatureUtil signatureUtil=new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求包结构体
            Map<String, Object> data = new HashMap<>();
            data.put("pageNo", 1);
            data.put("pageSize", 10);
            String jsonString = JSON.toJSONString(data);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, jsonString);
            //集成平台HTTP头部需要数据
            Map<String, Object> headerMap = signatureUtil.getBgyHeader(timestampStr,signature,account);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPost(url, data, headerMap);
            List<Map<String, Object>> mapList = new ArrayList<>();
            if (response != null) {
                //data作为key获取JSONObject
                JSONObject jsonObject = response.getJSONObject("data");
                if (jsonObject != null) {
                    List<Object> dataList = jsonObject.getJSONArray("list");
                    for (Object object : dataList) {
                        String jsonStr = JSONObject.toJSONString(object);
                        Map<String, Object> params = JSONObject.parseObject(jsonStr, new TypeReference<Map<String, Object>>() {
                        });
                        mapList.add(params);
                    }
                }
                System.out.println("mapList:" + mapList);
            }
        } catch (Exception e) {
            logger.error("获取集成平台用户权限列表接口请求异常：" + e.getMessage());
        }
    }

    @Override
    public void obtainBgyUserPermissionIncrement() {

    }
}
