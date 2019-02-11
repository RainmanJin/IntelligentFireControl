package cn.com.bgy.ifc.controller.api.external;

import cn.com.bgy.ifc.bgy.annotation.SystemLogSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.utils.onenet.Util;
import cn.com.bgy.ifc.entity.po.system.SystemOperationLog;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.AnalogService;
import cn.com.bgy.ifc.service.interfaces.inner.equipment.EquipmentEventService;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemOperationLogService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;

/**
 * @author: ZhangCheng
 * @description:外部接口调用
 * @date: 2019-01-17 14:40
 **/
@RestController
@RequestMapping("/external/interface")
public class ExternalInterfaceController {

    private static Logger logger = LoggerFactory.getLogger(ExternalInterfaceController.class);

    /**
     * 用户自定义token和OneNet第三方平台配置里的token一致
     */
    private static String token ="8AuJnP2fq35Uck1irba";
    /**
     * aeskey和OneNet第三方平台配置里的token一致
     */
    //private static String aeskey ="whBx2ZwAU5LOHVimPj1MPx56QRe3OsGGWRe4dr17crV";

    @Autowired
    private AnalogService analogService;

    @Autowired
    private EquipmentEventService equipmentEventService;

    @Autowired
    private SystemOperationLogService systemOperationLogService;

    /**
     * @author: ZhangCheng
     * @description:物联设备状态信息监听
     * @param: [resultStr]
     * @return: void
     */
    @PostMapping("deviceListen")
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


    /**
     * 功能描述：第三方平台数据接收。<p>
     *           <ul>注:
     *               <li>1.OneNet平台为了保证数据不丢失，有重发机制，如果重复数据对业务有影响，数据接收端需要对重复数据进行排除重复处理。</li>
     *               <li>2.OneNet每一次post数据请求后，等待客户端的响应都设有时限，在规定时限内没有收到响应会认为发送失败。
     *                    接收程序接收到数据时，尽量先缓存起来，再做业务逻辑处理。</li>
     *           </ul>
     * @param body 数据消息
     * @return 任意字符串。OneNet平台接收到http 200的响应，才会认为数据推送成功，否则会重发。
     */
    @PostMapping(value = "/receive")
    @SystemLogSave(type = SystemLogType.INTERFACE_LOG, description = "oneNet第三方平台数据接收", login = LoginState.NOT_LOGIN)
    public String receive(@RequestBody String body) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        logger.info("data receive:  body String --- " +body);
        /************************************************
         *  解析数据推送请求，非加密模式。
         *  如果是明文模式使用以下代码
         **************************************************/
        /*************明文模式  start****************/
        Util.BodyObj obj = Util.resolveBody(body, false);
        logger.info("data receive:  body Object --- " +obj);
        SystemOperationLog systemOperationLog = new SystemOperationLog();
        systemOperationLog.setLogType(SystemLogType.INTERFACE_LOG.getValue());
        systemOperationLog.setOperatorDescribe("oneNet第三方平台数据接收");
        if (obj != null){
            boolean dataRight = Util.checkSignature(obj, token);
            if (dataRight){
                systemOperationLog.setOperatorContent(obj.toString());
                systemOperationLogService.insertSystemLogInfo(systemOperationLog);
                logger.info("data receive: content" + obj.toString());
            }else {
                systemOperationLog.setOperatorContent("data receive: signature error");
                systemOperationLogService.insertSystemLogInfo(systemOperationLog);
                logger.info("data receive: signature error");
            }
        }else {
            systemOperationLog.setOperatorContent("data receive: body empty error");
            systemOperationLogService.insertSystemLogInfo(systemOperationLog);
            logger.info("data receive: body empty error");
        }
        /*************明文模式  end****************/


        /********************************************************
         *  解析数据推送请求，加密模式
         *
         *  如果是加密模式使用以下代码
         ********************************************************/
        /*************加密模式  start****************/
//        Util.BodyObj obj1 = Util.resolveBody(body, true);
//        logger.info("data receive:  body Object--- " +obj1);
//        if (obj1 != null){
//            boolean dataRight1 = Util.checkSignature(obj1, token);
//            if (dataRight1){
//                String msg = Util.decryptMsg(obj1, aeskey);
//                logger.info("data receive: content" + msg);
//            }else {
//                logger.info("data receive:  signature error " );
//            }
//        }else {
//            logger.info("data receive: body empty error" );
//        }
        /*************加密模式  end****************/
        return "ok";
    }

    /**
     * 功能说明： URL&Token验证接口。如果验证成功返回msg的值，否则返回其他值。
     * @param msg 验证消息
     * @param nonce 随机串
     * @param signature 签名
     * @return msg值
     */
    @GetMapping(value = "/receive")
    public String check(@RequestParam(value = "msg") String msg,
                        @RequestParam(value = "nonce") String nonce,
                        @RequestParam(value = "signature") String signature) throws UnsupportedEncodingException {
        logger.info("url&token check: msg:{} nonce{} signature:{}",msg,nonce,signature);
        SystemOperationLog systemOperationLog = new SystemOperationLog();
        systemOperationLog.setLogType(SystemLogType.INTERFACE_LOG.getValue());
        systemOperationLog.setOperatorDescribe("URL&Token验证接口");
        if (Util.checkToken(msg,nonce,signature,token)){
            systemOperationLog.setOperatorContent(msg);
            systemOperationLogService.insertSystemLogInfo(systemOperationLog);
            return msg;
        }else {
            systemOperationLog.setOperatorContent("error");
            systemOperationLogService.insertSystemLogInfo(systemOperationLog);
            return "error";
        }
    }
}
