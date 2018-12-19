package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.projects.BgyProjectVo;
import cn.com.bgy.ifc.service.interfaces.api.basic.BgyProjectService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void obtainBgyProject(int pageNo, int pageSize, Integer areaId) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/api/third/base/getProjectList";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                //区域id,为空则返回所有项目
                data.put("areaId", areaId);
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<BgyProjectVo> oList = new ArrayList<>();
                BgyProjectVo bgyProjectVo = new BgyProjectVo();
                ResponseUtil.getResultList(oList, bgyProjectVo, response, "data", "list");
                System.out.println("oList:" + oList);
            } else {
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台项目列表接口请求异常：" + e.getMessage());
        }
    }

    @Override
    public void obtainBgyProjectIncrement(int pageNo, int pageSize, Integer areaId) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                String url = config.getUrl() + "/api/third/base/getProjectListIncrement";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                //区域id,为空则返回所有项目
                data.put("startTime", "2018-10-01 01:00:00");
                data.put("areaId", areaId);
                data.put("pageNo", pageNo);
                data.put("pageSize", pageSize);
                String signature = SignatureUtil.getBgySignature(timestampStr, signKey, data);
                //集成平台HTTP头部需要数据
                Map<String, Object> headerMap = SignatureUtil.getBgyHeader(timestampStr, signature, account);
                //调用HTTP请求
                JSONObject response = HttpHelper.httpPost(url, data, headerMap);
                List<BgyProjectVo> oList = new ArrayList<>();
                BgyProjectVo bgyProjectVo = new BgyProjectVo();
                ResponseUtil.getResultList(oList, bgyProjectVo, response, "data", "list");
                System.out.println("oList:" + oList);
            } else {
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台项目列表（增量）接口请求异常：" + e.getMessage());
        }
    }
}
