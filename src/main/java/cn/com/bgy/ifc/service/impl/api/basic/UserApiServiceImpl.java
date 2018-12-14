package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyUserVo;
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
    private AccountDomain accountDomain;

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    /**
     * @author: ZhangCheng
     * @description:集成平台验证登录用户
     * @param: [telephone, password]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> obtainBgyUserLogin(String telephone, String password) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() == 0) {
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
            ExternalInterfaceConfig config = list.get(0);
            String url = config.getUrl() + "/api/third/user/login";
            String account = config.getAccount();
            String signKey = config.getSignKey();
            String timestampStr = SignatureUtil.timestampStr();
            // 请求数据
            Map<String, Object> data = new HashMap<>();
            //加密明文密码
            String cipherText = SignatureUtil.getBgyMd5(password);
            data.put("telephone", telephone);
            data.put("password", cipherText);
            String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
            //集成平台HTTP头部需要数据
            Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
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
                } else {
                    return ResponseVO.exception();
                }
            } else {
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
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() == 0) {
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
            ExternalInterfaceConfig config = list.get(0);
            String url = config.getUrl() + "/api/third/user/updatePwd";
            String account = config.getAccount();
            String signKey = config.getSignKey();
            String timestampStr = SignatureUtil.timestampStr();
            // 请求数据
            Map<String, Object> data = new HashMap<>();
            //加密明文密码
            String cipherText = SignatureUtil.getBgyMd5(password);
            data.put("telephone", telephone);
            data.put("password", cipherText);
            String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
            //集成平台HTTP头部需要数据
            Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPut(url, data, headerMap);
            if (response != null) {
                //data作为key获取JSONObject
                // statusCode
                String statusCode = response.getString("statusCode");
                if (!statusCode.equals("200")) {
                    String info = response.getString("info");
                    return ResponseVO.error().setMsg(info);
                } else {
                    return ResponseVO.success().setMsg("修改成功");
                }
            } else {
                return ResponseVO.exception();
            }
        } catch (Exception e) {
            logger.error("集成平台修改用户密码接口请求异常：" + e.getMessage());
            return ResponseVO.exception();
        }
    }

    @SystemLogAfterSave(type=7,description = "获取集成平台用户列表")
    @Override
    public ResponseVO<Object> obtainBgyUser(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/api/third/user/getUserList";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                long orgId=config.getOrgId();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                data.put("pageNo",pageNo);
                data.put("pageSize", pageSize);
                String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<BgyUserVo> oList = new ArrayList<>();
                BgyUserVo bgyUserVo=new BgyUserVo();
                ResponseUtil.getResultList(oList,bgyUserVo,response,"data","list");
                int totalCount=oList.size();
                int addCount=0;
                if(totalCount>0){
                    for (BgyUserVo userVo : oList) {
                        userVo.setOrgId(orgId);
                        int count=accountDomain.saveBgyAccount(userVo);
                        if(count==1){

                        }else{

                        }
                    }
                }
                if(addCount>0){

                }else{

                }
                ExternalInterfaceMsg externalInterfaceMsg=new ExternalInterfaceMsg();
                externalInterfaceMsg.setTotalCount(totalCount);
                externalInterfaceMsg.setAddCount(addCount);
                externalInterfaceMsgDomain.insertSelective(externalInterfaceMsg);
                return ResponseVO.exception();
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台用户列表接口请求异常：" + e.getMessage());
            return ResponseVO.exception().setMsg("获取集成平台用户列表接口请求异常！");
        }
    }

    @SystemLogAfterSave(type=7,description = "获取集成平台用户列表(增量)")
    @Override
    public ResponseVO<Object> obtainBgyUserIncrement(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/api/third/user/getUserListIncrement";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                long orgId=config.getOrgId();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                data.put("startTime", "2018-10-01 01:00:00");
                data.put("pageNo",pageNo);
                data.put("pageSize", pageSize);
                String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<BgyUserVo> oList = new ArrayList<>();
                BgyUserVo bgyUserVo=new BgyUserVo();
                ResponseUtil.getResultList(oList,bgyUserVo,response,"data","list");
                if(oList.size()>0){
                    for (BgyUserVo userVo : oList) {
                        userVo.setOrgId(orgId);
                        int count=accountDomain.saveBgyAccount(userVo);
                        if(count==1){

                        }else{

                        }
                    }
                }
                return ResponseVO.exception();
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.exception();
            }
        } catch (Exception e) {
            logger.error("请求接口异常：" + e.getMessage());
            return ResponseVO.exception();
        }
    }

    @Override
    public void obtainBgyUserPermission() {
        try {
            String url = "http://47.107.20.19:9002/integration/api/third/user/getUserPermissionIncrement";
            String account = "fire-fighting";
            String signKey = "C1CF1733-1C64-4F6C-9138-6F968A1BBE9B";
            String timestampStr = SignatureUtil.timestampStr();
            // 请求包结构体
            Map<String, Object> data = new HashMap<>();
            data.put("startTime", "");
            data.put("pageNo", 1);
            data.put("pageSize", 10);
            String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
            //集成平台HTTP头部需要数据
            Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
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
        try {
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
