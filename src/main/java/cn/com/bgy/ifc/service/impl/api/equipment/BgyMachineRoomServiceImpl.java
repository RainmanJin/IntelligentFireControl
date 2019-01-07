package cn.com.bgy.ifc.service.impl.api.equipment;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ExceptionUtil;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.bgy.utils.TimeUtil;
import cn.com.bgy.ifc.domain.interfaces.project.RegionComputerRoomDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.HttpVo;
import cn.com.bgy.ifc.entity.vo.equipment.BgyMachineRoomVo;
import cn.com.bgy.ifc.service.interfaces.api.equipment.BgyMachineRoomService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台机房信息同步
 * @date: 2018-12-19 19:26
 **/
@Service
public class BgyMachineRoomServiceImpl implements BgyMachineRoomService {

    private static Logger logger = LoggerFactory.getLogger(BgyMachineRoomServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Autowired
    private RegionComputerRoomDomain regionComputerRoomDomain;

    @SystemLogAfterSave(type = SystemLogType.INTERFACE_LOG, description = "同步集成平台机房数据",login = LoginState.NOT_LOGIN)
    @Override
    public ResponseVO<Object> baseObtainBgyMachineRoom(int pageNo, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long orgId = config.getOrgId();
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_MOTOR_ROOM_OBTAIN.getValue(), orgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyMachineRoomIncrement(pageNo, pageSize, config, createTime);
                } else {
                    return obtainBgyMachineRoom(pageNo, pageSize, config);
                }
            } else {
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台机房数据接口请求异常：", e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取集成平台机房数据接口请求异常！",e));
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyMachineRoom(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception {
        String reqUrl = "/api/third/equipment/getMachineRoomList";
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
        List<BgyMachineRoomVo> oList = new ArrayList<>();
        BgyMachineRoomVo roomVo = new BgyMachineRoomVo();
        ResponseUtil.getResultList(oList, roomVo, response, "data", "equipmentMachineRoomVoList");
        if (pageCount != 0) {
            ResponseUtil.getResultByPage(pageNo, pageSize, pageCount, config, reqUrl, oList, roomVo, "data", "equipmentMachineRoomVoList");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return regionComputerRoomDomain.saveBgyComputerRoomList(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台机房数据同步！");
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyMachineRoomIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        String reqUrl = "/api/third/equipment/getMachineRoomIncrement";
        Long orgId = config.getOrgId();
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
        List<BgyMachineRoomVo> oList = new ArrayList<>();
        BgyMachineRoomVo roomVo = new BgyMachineRoomVo();
        ResponseUtil.getResultList(oList, roomVo, response, "data", "list");
        if (pageCount != 0) {
            ResponseUtil.getIncResultByPage(pageNo, pageSize, dateTime, pageCount, config, reqUrl, oList, roomVo, "data", "list");
        }
        int totalCount = oList.size();
        if (totalCount > 0) {
            return regionComputerRoomDomain.alterBgyComputerRoomList(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台机房增量数据同步！");
        }
    }
}
