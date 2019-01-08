package cn.com.bgy.ifc.service.impl.api.fireinspection;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.utils.ExceptionUtil;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.api.fireinspection.BgyFireTaskTrainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台消防培训同步
 * @date: 2019-01-08 09:26
 **/
@Service
public class BgyFireTaskTrainServiceImpl implements BgyFireTaskTrainService {

    private static Logger logger = LoggerFactory.getLogger(BgyFireTaskTrainServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @SystemLogAfterSave(type = SystemLogType.INTERFACE_LOG, description = "同步集成平台消防培训数据",login = LoginState.NOT_LOGIN )
    @Override
    public ResponseVO<Object> baseObtainBgyFireTaskTrain(int pageNum, int pageSize) {
        try {
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long orgId = config.getOrgId();
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_FIRE_TRAIN_OBTAIN.getValue(), orgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyFireTaskTrainIncrement(pageNum, pageSize, config, createTime);
                } else {
                    return obtainBgyFireTaskTrain(pageNum, pageSize, config);
                }
            } else {
                return ResponseVO.error().setMsg("获取集成平台接口配置数据失败！");
            }
        } catch (Exception e) {
            logger.error("获取集成平台消防培训数据接口请求异常：" , e);
            return ResponseVO.error().setMsg(ExceptionUtil.getExceptionMsg("获取集成平台消防培训数据接口请求异常！",e));
        }
    }

    @Override
    public ResponseVO<Object> obtainBgyFireTaskTrain(int pageNum, int pageSize, ExternalInterfaceConfig config) throws Exception {
        return null;
    }

    @Override
    public ResponseVO<Object> obtainBgyFireTaskTrainIncrement(int pageNum, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        return null;
    }
}
