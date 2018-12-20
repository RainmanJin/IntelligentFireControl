package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.HttpVo;
import cn.com.bgy.ifc.entity.vo.projects.BgyOrgVo;
import cn.com.bgy.ifc.service.interfaces.api.basic.BgyOrgService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台机构同步
 * @date: 2018-12-19 18:21
 **/
@Service
public class BgyOrgServiceImpl implements BgyOrgService {

    private static Logger logger = LoggerFactory.getLogger(UserApiServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Override
    public ResponseVO<Object> baseObtainBgyOrg(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long orgId = config.getOrgId();
                //机构日志
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_ORG_OBTAIN.getValue(), orgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyOrgIncrement(pageNo, pageSize, config, createTime);
                } else {
                    return obtainBgyOrg(pageNo, pageSize, config);
                }
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台机构列表接口请求异常：" + e);
            return ResponseVO.error().setMsg("获取集成平台机构列表接口请求异常！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyOrg(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception {
        String reqUrl = "/api/third/base/getOrgList";
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyOrgVo> oList = new ArrayList<>();
        BgyOrgVo bgyUserVo = new BgyOrgVo();
        ResponseUtil.getResultList(oList, bgyUserVo, response, "data", "list");
        System.out.println("====" + oList);

        return null;
    }

    @Override
    public ResponseVO<Object> obtainBgyOrgIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        String reqUrl = "/api/third/base/getOrgIncrement";
        //格式化时间字符串
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
        List<BgyOrgVo> oList = new ArrayList<>();
        BgyOrgVo bgyUserVo = new BgyOrgVo();
        ResponseUtil.getResultList(oList, bgyUserVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getIncResultByPage(pageNo, pageSize, dateTime, pageCount, config, reqUrl, oList, bgyUserVo, "data", "list");
        }
        return null;
    }
}
