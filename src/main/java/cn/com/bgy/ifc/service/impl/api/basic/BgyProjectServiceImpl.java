package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.service.interfaces.api.basic.BgyProjectService;
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

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-11 16:23
 **/
@Service
public class BgyProjectServiceImpl implements BgyProjectService {

    private static Logger logger = LoggerFactory.getLogger(BgyProjectServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Override
    public void obtainBgyProject() {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryIntegrationConfig();
            if(list.size()!=0){
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/api/third/base/getProjectList";
                String account = config.getAccount();
                String signKey = config.getSignKey();
                String timestampStr = SignatureUtil.timestampStr();
                // 请求包结构体
                Map<String, Object> data = new HashMap<>();
                //区域id,为空则返回所有项目
                data.put("areaId", null);
                data.put("pageNo", 2);
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
            }else{
                logger.info("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台项目列表接口请求异常：" + e.getMessage());
        }
    }

    @Override
    public void obtainBgyProjectIncrement() {

    }
}
