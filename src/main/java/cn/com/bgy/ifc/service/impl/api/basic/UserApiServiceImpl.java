package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.api.basic.UserApiService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserApiServiceImpl implements UserApiService {

    private static Logger logger = LoggerFactory.getLogger(UserApiServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    /**
     * @author: ZhangCheng
     * @description:集成平台验证登录用户
     * @param: [telephone, password]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> obtainBgyUserLogin(String telephone, String password) {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()==0){
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
            ExternalInterfaceConfig config=list.get(0);
            String url = config.getUrl()+"/api/third/user/login";
            String account = config.getAccount();
            String signKey = config.getSignKey();
            SignatureUtil signatureUtil = new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求数据
            Map<String, Object> data = new HashMap<>();
            //加密明文密码
            String cipherText = signatureUtil.getBgyMd5(password);
            data.put("telephone", telephone);
            data.put("password", cipherText);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, data);
            //集成平台HTTP头部需要数据
            Map<String, Object> headerMap = signatureUtil.getBgyHeader(timestampStr, signature, account);
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
                    ResponseVO.success().setMsg("验证成功");
                    return ResponseVO.success().setData(userId);
                }else{
                    return ResponseVO.exception();
                }
            }else{
                return ResponseVO.exception();
            }
        } catch (Exception e) {
            logger.error("集成平台验证登录用户接口请求异常：" + e.getMessage());
            return ResponseVO.exception();
        }
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
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()==0){
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
            ExternalInterfaceConfig config=list.get(0);
            String url = config.getUrl()+"/api/third/user/updatePwd";
            String account = config.getAccount();
            String signKey = config.getSignKey();
            SignatureUtil signatureUtil = new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求数据
            Map<String, Object> data = new HashMap<>();
            //加密明文密码
            String cipherText = signatureUtil.getBgyMd5(password);
            data.put("telephone", telephone);
            data.put("password", cipherText);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, data);
            //集成平台HTTP头部需要数据
            Map<String, Object> headerMap = signatureUtil.getBgyHeader(timestampStr, signature, account);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPut(url, data, headerMap);
            if (response != null) {
                //data作为key获取JSONObject
                // statusCode
                System.out.println("response:"+response.toString());
                String statusCode = response.getString("statusCode");
                if (!statusCode.equals("200")) {
                    String info = response.getString("info");
                    return ResponseVO.error().setMsg(info);
                }else{
                    return ResponseVO.success().setMsg("修改成功");
                }
            }else{
                return ResponseVO.exception();
            }
        } catch (Exception e) {
            logger.error("集成平台修改用户密码接口请求异常：" + e.getMessage());
            return ResponseVO.exception();
        }
    }

    @Override
    public void obtainBgyUser() {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()!=0){
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/api/third/user/getUserList";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                SignatureUtil signatureUtil = new SignatureUtil();
                String timestampStr = signatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                data.put("pageNo", 2);
                data.put("pageSize", 10);
                String signature = signatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = signatureUtil.getBgyHeader(timestampStr, signature, account);
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
            }else{
                logger.info("获取集成平台接口配置数据失败！");
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
            SignatureUtil signatureUtil = new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求包结构体
            Map<String, Object> data = new HashMap<>();
            data.put("startTime", "");
            data.put("pageNo", 1);
            data.put("pageSize", 10);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, data);
            //集成平台HTTP头部需要数据
            Map<String, Object> headerMap = signatureUtil.getBgyHeader(timestampStr, signature, account);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPost(url, data, headerMap);
            if (response != null) {

            }
        } catch (Exception e) {
            logger.error("请求接口异常：" + e.getMessage());
        }
    }

    @Override
    public void obtainBgyUserPermission() {
        try {
            String url = "http://47.107.20.19:9002/integration/api/third/user/getUserPermissionIncrement";
            String account = "fire-fighting";
            String signKey = "C1CF1733-1C64-4F6C-9138-6F968A1BBE9B";
            SignatureUtil signatureUtil = new SignatureUtil();
            String timestampStr = signatureUtil.timestampStr();
            // 请求包结构体
            Map<String, Object> data = new HashMap<>();
            data.put("startTime", "");
            data.put("pageNo", 1);
            data.put("pageSize", 10);
            String signature = signatureUtil.getBgySignature(timestampStr, signKey, data);
            //集成平台HTTP头部需要数据
            Map<String, Object> headerMap = signatureUtil.getBgyHeader(timestampStr, signature, account);
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
        try{
        String url = "http://47.107.20.19:9002/integration/api/third/user/getUserPermission";
        String account = "fire-fighting";
        String signKey = "C1CF1733-1C64-4F6C-9138-6F968A1BBE9B";
        SignatureUtil signatureUtil = new SignatureUtil();
        String timestampStr = signatureUtil.timestampStr();
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("pageNo", 1);
        data.put("pageSize", 10);
        String signature = signatureUtil.getBgySignature(timestampStr, signKey, data);
        //集成平台HTTP头部需要数据
        Map<String, Object> headerMap = signatureUtil.getBgyHeader(timestampStr, signature, account);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(url, data, headerMap);
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (response != null) {

        }
        } catch (Exception e) {
            logger.error("获取集成平台用户权限列表（增量）接口请求异常：" + e.getMessage());
        }
    }
}
