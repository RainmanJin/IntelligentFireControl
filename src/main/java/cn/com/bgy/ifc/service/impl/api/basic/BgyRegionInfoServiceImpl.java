package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.system.project.RegionInfoDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.HttpVo;
import cn.com.bgy.ifc.entity.vo.projects.BgyRegionInfoVo;
import cn.com.bgy.ifc.service.interfaces.api.basic.BgyRegionInfoService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台区域同步
 * @date: 2018-12-19 18:21
 **/
@Service
public class BgyRegionInfoServiceImpl implements BgyRegionInfoService {

    private static Logger logger = LoggerFactory.getLogger(BgyRegionInfoServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Autowired
    private RegionInfoDomain regionInfoDomain;

    @SystemLogAfterSave(type = 7, description = "同步集成平台区域数据")
    @Override
    public ResponseVO<Object> baseObtainBgyRegionInfo(int pageNo, int pageSize, Integer orgId) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long myOrgId = config.getOrgId();
                //机构日志
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_REGION_OBTAIN.getValue(), myOrgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyRegionInfoIncrement(pageNo, pageSize, config, createTime, orgId);
                } else {
                    return obtainBgyRegionInfo(pageNo, pageSize, config, orgId);
                }
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台区域列表接口请求异常：" + e);
            return ResponseVO.error().setMsg("获取集成平台区域列表接口请求异常！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyRegionInfo(int pageNo, int pageSize, ExternalInterfaceConfig config, Integer orgId) throws Exception {
        String reqUrl = "/api/third/base/getAreaList";
        long myOrgId = config.getOrgId();
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        //机构id,默认为1
        data.put("orgId", orgId);
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyRegionInfoVo> oList = new ArrayList<>();
        BgyRegionInfoVo bgyRegionInfoVo = new BgyRegionInfoVo();
        ResponseUtil.getResultList(oList, bgyRegionInfoVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getResultByPage(pageNo, pageSize, pageCount, config, reqUrl, oList, bgyRegionInfoVo, "data", "list");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return regionInfoDomain.saveBgyRegionInfo(oList, myOrgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台区域数据同步！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyRegionInfoIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime, Integer orgId) throws Exception {
        String reqUrl = "/api/third/base/getAreaListIncrement";
        long myOrgId = config.getOrgId();
        //格式化时间字符串
        String dateTime = TimeUtil.parseDateToStr(createTime);
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        //机构id,默认为1
        data.put("orgId", orgId);
        data.put("startTime", dateTime);
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        //集成平台HTTP头部需要数据
        HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
        //调用HTTP请求
        JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyRegionInfoVo> oList = new ArrayList<>();
        BgyRegionInfoVo bgyRegionInfoVo = new BgyRegionInfoVo();
        ResponseUtil.getResultList(oList, bgyRegionInfoVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getIncResultByPage(pageNo, pageSize, dateTime, pageCount, config, reqUrl, oList, bgyRegionInfoVo, "data", "list");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return regionInfoDomain.alterBgyRegionInfo(oList, myOrgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台区域增量数据同步！");
        }
    }
}
