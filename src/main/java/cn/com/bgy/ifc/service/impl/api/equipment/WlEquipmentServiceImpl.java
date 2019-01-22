package cn.com.bgy.ifc.service.impl.api.equipment;

import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ExceptionUtil;
import cn.com.bgy.ifc.dao.equipment.EquipmentStateDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.api.equipment.WlEquipmentService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:物联网设备接口信息同步
 * @date: 2019-01-09 11:15
 **/
public class WlEquipmentServiceImpl implements WlEquipmentService {

    private static Logger logger = LoggerFactory.getLogger(WlEquipmentServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Override
    public ResponseVO<Object> createWlEquipment() {
        try {
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryInternetThingConfig();
            if(list.size() != 0){
                String url = "http://101.37.16.25:9080/device/devices";
                Map<String, Object> data = new HashMap<>();
                data.put("type",1);
                data.put("name","testDevice");
                data.put("thirdDeviceId","D8B04C3EF4");
                JSONObject response = HttpHelper.httpPost(url, data, null);
                System.out.println(response);
                return null;
            }else{
                return ResponseVO.error().setMsg("获取物联网设备接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台设备信息列表接口请求异常：" , e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取集成平台设备信息列表接口请求异常！",e));
        }
    }

    @Override
    public ResponseVO<Object> saveWlEquipment() {
        try{
            List<ExternalInterfaceConfig> list=externalInterfaceConfigDomain.queryInternetThingConfig();
            if(list.size() != 0) {
                ExternalInterfaceConfig config=list.get(0);
                String url = config.getUrl()+"/device/devices";
                JSONObject response =HttpHelper.httpGet(url,null);
                System.out.println(response);
                return null;
            }else{
                return ResponseVO.error().setMsg("获取物联网设备接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台设备信息列表接口请求异常：" , e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取集成平台设备信息列表接口请求异常！",e));
        }
    }
}
