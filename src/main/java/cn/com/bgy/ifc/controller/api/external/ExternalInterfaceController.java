package cn.com.bgy.ifc.controller.api.external;

import cn.com.bgy.ifc.bgy.annotation.SystemLogSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.AnalogService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentEventService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:外部接口调用
 * @date: 2019-01-17 14:40
 **/
@RestController
@RequestMapping("/external/interface")
public class ExternalInterfaceController {

    @Autowired
    private AnalogService analogService;

    @Autowired
    private EquipmentEventService equipmentEventService;

    /**
     * @author: ZhangCheng
     * @description:物联设备状态信息监听
     * @param: [resultStr]
     * @return: void
     */
    @PostMapping("deviceListen")
    @SystemLogSave(type = SystemLogType.INTERFACE_LOG, description = "物联设备状态信息监听", login = LoginState.NOT_LOGIN)
    public void deviceListen(@RequestBody JSONObject result) {
        if (result != null) {
            int type = result.getInteger("type");
            JSONObject jsonObject = result.getJSONObject("data");
            int eventType=1;
            int analogType=2;
            //事件
            if (type == eventType) {
                equipmentEventService.insertEquipmentEvent(jsonObject);
            }
            //模拟量
            if (type == analogType) {
                analogService.insertAnalog(jsonObject);
            }
        }
    }
}
