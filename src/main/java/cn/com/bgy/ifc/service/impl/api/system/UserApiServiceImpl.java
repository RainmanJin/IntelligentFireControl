package cn.com.bgy.ifc.service.impl.api.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.domain.interfaces.system.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.HttpVo;
import cn.com.bgy.ifc.entity.vo.system.BgyUserPermissionVo;
import cn.com.bgy.ifc.entity.vo.system.BgyUserVo;
import cn.com.bgy.ifc.service.interfaces.api.system.UserApiService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
            String reqUrl = "/api/third/user/login";
            // 请求数据
            Map<String, Object> data = new HashMap<>();
            //加密明文密码
            String cipherText = SignatureUtil.getBgyMd5(password);
            data.put("telephone", telephone);
            data.put("password", cipherText);
            HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
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
                return ResponseVO.error().setMsg("集成平台验证登录用户请求失败!");
            }
        } catch (Exception e) {
            logger.error("集成平台验证登录用户接口请求异常：" + e);
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
            String reqUrl = "/api/third/user/updatePwd";
            // 请求数据
            Map<String, Object> data = new HashMap<>();
            //加密明文密码
            String cipherText = SignatureUtil.getBgyMd5(password);
            data.put("telephone", telephone);
            data.put("password", cipherText);
            HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPut(httpVo.getUrl(), data, httpVo.getHeaderMap());
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
                return ResponseVO.error().setMsg("集成平台修改用户请求失败!");
            }
        } catch (Exception e) {
            logger.error("集成平台修改用户密码接口请求异常：" + e);
            return ResponseVO.exception();
        }
    }

    @SystemLogAfterSave(type = 7, description = "同步集成平台用户数据")
    @Override
    public ResponseVO<Object> baseObtainBgyUser(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long orgId = config.getOrgId();
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_ACCOUNT_OBTAIN.getValue(), orgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyUserIncrement(pageNo, pageSize, config, createTime);
                } else {
                    return obtainBgyUser(pageNo, pageSize, config);
                }
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台用户列表接口请求异常：" + e);
            return ResponseVO.error().setMsg("获取集成平台用户列表接口请求异常！");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:用户信息全量
     * @param: [pageNo, pageSize, config]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> obtainBgyUser(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception {
        String reqUrl = "/api/third/user/getUserList";
        Long orgId = config.getOrgId();
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //调用HTTP请求
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyUserVo> oList = new ArrayList<>();
        BgyUserVo bgyUserVo = new BgyUserVo();
        ResponseUtil.getResultList(oList, bgyUserVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getResultByPage(pageNo, pageSize, pageCount, config, reqUrl, oList, bgyUserVo, "data", "list");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return accountDomain.saveBgyAccountList(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台用户数据同步！");
        }
    }

    /**
     * @author: ZhangCheng
     * @description:用户信息增量
     * @param: [pageNo, pageSize, config, createTime]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @Override
    public ResponseVO<Object> obtainBgyUserIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        String reqUrl = "/api/third/user/getUserListIncrement";
        long orgId = config.getOrgId();
        String dateTime = TimeUtil.parseDateToStr(createTime);
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("startTime", dateTime);
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyUserVo> oList = new ArrayList<>();
        BgyUserVo bgyUserVo = new BgyUserVo();
        ResponseUtil.getResultList(oList, bgyUserVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getIncResultByPage(pageNo, pageSize, dateTime, pageCount, config, reqUrl, oList, bgyUserVo, "data", "list");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return accountDomain.alterBgyAccountList(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台用户增量数据同步！");
        }
    }

    @SystemLogAfterSave(type = 7, description = "同步集成平台用户权限数据")
    @Override
    public ResponseVO<Object> baseObtainBgyUserPermission(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long orgId = config.getOrgId();
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_PERMISSION_OBTAIN.getValue(), orgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyUserPermissionIncrement(pageNo, pageSize, config, createTime);
                } else {
                    return obtainBgyUserPermission(pageNo, pageSize, config);
                }
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台用户列表增量接口请求异常：" + e);
            return ResponseVO.error().setMsg("获取集成平台用户列表接口请求异常！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyUserPermission(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception {
        String reqUrl = "/api/third/user/getUserPermission";
        long orgId = config.getOrgId();
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        System.out.println("====" + response);
        // 总页数
        /*int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyUserPermissionVo> oList = new ArrayList<>();
        BgyUserPermissionVo bgyUserVo = new BgyUserPermissionVo();
        ResponseUtil.getResultList(oList, bgyUserVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getResultByPage(pageNo, pageSize, pageCount, config, reqUrl, oList, bgyUserVo, "data", "list");
        }
        System.out.println("====" + oList);*/
        return null;
    }

    @Override
    public ResponseVO<Object> obtainBgyUserPermissionIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        String reqUrl = "/api/third/user/getUserPermissionIncrement";
        long orgId = config.getOrgId();
        String dateTime = TimeUtil.parseDateToStr(createTime);
        Map<String, Object> data = new HashMap<>();
        data.put("startTime", dateTime);
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyUserPermissionVo> oList = new ArrayList<>();
        BgyUserPermissionVo bgyUserVo = new BgyUserPermissionVo();
        ResponseUtil.getResultList(oList, bgyUserVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getIncResultByPage(pageNo, pageSize, dateTime, pageCount, config, reqUrl, oList, bgyUserVo, "data", "list");
        }
        return null;
    }


}
