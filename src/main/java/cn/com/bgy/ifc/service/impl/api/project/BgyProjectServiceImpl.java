package cn.com.bgy.ifc.service.impl.api.project;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.domain.interfaces.project.RegionInfoDomain;
import cn.com.bgy.ifc.domain.interfaces.project.RegionProjectDomain;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.HttpVo;
import cn.com.bgy.ifc.entity.vo.project.BgyProjectVo;
import cn.com.bgy.ifc.service.interfaces.api.project.BgyProjectService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: ZhangCheng
 * @description:获取碧桂园集成平台项目信息
 * @date: 2018-12-11 16:23
 **/
@Service
public class BgyProjectServiceImpl implements BgyProjectService {

    private static Logger logger = LoggerFactory.getLogger(BgyProjectServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Autowired
    private RegionProjectDomain regionProjectDomain;

    @Autowired
    private RegionInfoDomain regionInfoDomain;

    @SystemLogAfterSave(type = 5, description = "同步集成平台项目数据")
    @Override
    public ResponseVO<Object> baseObtainBgyProject(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long myOrgId = config.getOrgId();
                List<RegionInfo> infoList= regionInfoDomain.findByOrgId(myOrgId);
                //机构日志
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_PROJECT_OBTAIN.getValue(), myOrgId);
                if(infoList.size()>0) {
                    if (msgList.size() > 0) {
                        ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                        Date createTime = interfaceMsg.getCreateTime();
                        return obtainBgyProjectIncrement(pageNo, pageSize, config, createTime, infoList);
                    } else {
                        return obtainBgyProject(pageNo, pageSize, config, infoList);
                    }
                }else{
                    return ResponseVO.error().setMsg("获取集成平台区域数据异常！");
                }
            } else {
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取集成平台项目列表接口请求异常：" + e);
            return ResponseVO.error().setMsg("获取集成平台项目列表接口请求异常！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyProject(int pageNo, int pageSize, ExternalInterfaceConfig config,List<RegionInfo> infoList) throws Exception {
        String reqUrl = "/api/third/base/getProjectList";
        long myOrgId = config.getOrgId();
        int size=infoList.size();
        List<BgyProjectVo> oList = new ArrayList<>();
        BgyProjectVo bgyProjectVo = new BgyProjectVo();
        for(int i=0;i<size;i++) {
            // 请求包结构体
            Map<String, Object> data = new HashMap<>();
            //区域id,为空则返回所有项目
            data.put("areaId", infoList.get(i).getId());
            data.put("pageNo", pageNo);
            data.put("pageSize", pageSize);
            //集成平台HTTP头部需要数据
            HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
            // 总页数
            int pageCount = ResponseUtil.getPageCount(response, pageSize);

            ResponseUtil.getResultList(oList, bgyProjectVo, response, "data", "list");
            if (pageCount != 0) {
                ResponseUtil.getResultByPage(pageNo, pageSize, pageCount, config, reqUrl, oList, bgyProjectVo, "data", "list");
            }
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return regionProjectDomain.saveBgyRegionProject(oList, myOrgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台项目数据同步！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyProjectIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime,List<RegionInfo> infoList) throws Exception {
        String reqUrl = "/api/third/base/getProjectListIncrement";
        long myOrgId = config.getOrgId();
        int size=infoList.size();
        List<BgyProjectVo> oList = new ArrayList<>();
        BgyProjectVo bgyProjectVo = new BgyProjectVo();
        for(int i=0;i<size;i++) {
            //格式化时间字符串
            String dateTime = TimeUtil.parseDateToStr(createTime);
            // 请求包结构体
            Map<String, Object> data = new HashMap<>();
            //区域id,为空则返回所有项目
            data.put("areaId", infoList.get(i).getId());
            data.put("startTime", dateTime);
            data.put("pageNo", pageNo);
            data.put("pageSize", pageSize);
            //集成平台HTTP头部需要数据
            HttpVo httpVo = SignatureUtil.getHttpVo(config, reqUrl, data);
            //调用HTTP请求
            JSONObject response = HttpHelper.httpPost(httpVo.getUrl(), data, httpVo.getHeaderMap());
            // 总页数
            int pageCount = ResponseUtil.getPageCount(response, pageSize);
            ResponseUtil.getResultList(oList, bgyProjectVo, response, "data", "list");
            if (pageCount != 0) {
                ResponseUtil.getIncResultByPage(pageNo, pageSize, dateTime, pageCount, config, reqUrl, oList, bgyProjectVo, "data", "list");
            }
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return regionProjectDomain.alterBgyRegionProject(oList, myOrgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台项目增量数据同步！");
        }
    }
}
