package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.helper.HttpHelper;
import cn.com.bgy.ifc.bgy.utils.ResponseUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.HttpVo;
import cn.com.bgy.ifc.entity.vo.projects.BgyMachineRoomVo;
import cn.com.bgy.ifc.service.interfaces.api.basic.BgyMachineRoomService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: ZhangCheng
 * @description:
 * @date: 2018-12-19 19:26
 **/
@Service
public class BgyMachineRoomServiceImpl implements BgyMachineRoomService {

    private static Logger logger = LoggerFactory.getLogger(UserApiServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

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
                logger.info("获取集成平台接口配置数据失败！");
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台机构列表接口请求异常：" + e);
            return ResponseVO.error().setMsg("获取集成平台机构列表接口请求异常！");
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
        System.out.println("xxx"+response);
        // 总页数
        int pageCount = ResponseUtil.getPageCount(response, pageSize);
        List<BgyMachineRoomVo> oList = new ArrayList<>();
        BgyMachineRoomVo roomVo = new BgyMachineRoomVo();
        ResponseUtil.getResultList(oList, roomVo, response, "data", "equipmentMachineRoomVoList");
        System.out.println(oList);
        /*if (pageCount != 0) {
            ResponseUtil.getResultByPage(pageNo, pageSize, pageCount, config, reqUrl, oList, bgyUserVo, "data", "list");
        }*/
        int totalCount = oList.size();
        /*if (totalCount > 0) {
            return accountDomain.saveBgyAccountList(oList, orgId);
        } else {
            return ResponseVO.success().setMsg("暂无集成平台用户数据同步！");
        }*/
        return null;
    }

    @Override
    public ResponseVO<Object> obtainBgyMachineRoomIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        String reqUrl = "/api/third/equipment/getMachineRoomIncrement";
        Long orgId = config.getOrgId();
        // 请求包结构体
        Map<String, Object> data = new HashMap<>();
        data.put("pageNo", pageNo);
        data.put("pageSize", pageSize);
        return null;
    }
}
