package cn.com.bgy.ifc.service.impl.api.basic;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceConfigDomain;
import cn.com.bgy.ifc.domain.interfaces.system.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceConfig;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceMsg;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.api.basic.BgyOrgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:碧桂园集成平台机构同步
 * @date: 2018-12-19 18:21
 **/
@Service
public class BgyOrgServiceImpl implements BgyOrgService {

    private static Logger logger = LoggerFactory.getLogger(UserApiServiceImpl.class);

    @Autowired
    private ExternalInterfaceConfigDomain externalInterfaceConfigDomain;

    @Autowired
    private ExternalInterfaceMsgDomain externalInterfaceMsgDomain;

    @Override
    public ResponseVO<Object> baseObtainBgyOrg(int pageNo, int pageSize) {
        try{
            List<ExternalInterfaceConfig> list = externalInterfaceConfigDomain.queryIntegrationConfig();
            if (list.size() != 0) {
                ExternalInterfaceConfig config = list.get(0);
                Long orgId = config.getOrgId();
                //机构日志
                List<ExternalInterfaceMsg> msgList = externalInterfaceMsgDomain.queryBgyInterfaceMsg(ExternalConstant.MsgTypeValue.BGY_ORG_OBTAIN.getValue(), orgId);
                if (msgList.size() > 0) {
                    ExternalInterfaceMsg interfaceMsg = msgList.get(0);
                    Date createTime = interfaceMsg.getCreateTime();
                    return obtainBgyOrgIncrement(pageNo, pageSize, config, createTime);
                } else {
                    return obtainBgyOrg(pageNo, pageSize, config);
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
    public ResponseVO<Object> obtainBgyOrg(int pageNo, int pageSize, ExternalInterfaceConfig config) throws Exception {
        return null;
    }

    @Override
    public ResponseVO<Object> obtainBgyOrgIncrement(int pageNo, int pageSize, ExternalInterfaceConfig config, Date createTime) throws Exception {
        return null;
    }
}
