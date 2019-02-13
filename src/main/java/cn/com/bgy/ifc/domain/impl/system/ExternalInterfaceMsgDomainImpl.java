package cn.com.bgy.ifc.domain.impl.system;

import cn.com.bgy.ifc.bgy.constant.ExternalConstant;
import cn.com.bgy.ifc.dao.system.ExternalInterfaceMsgDao;
import cn.com.bgy.ifc.domain.interfaces.system.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceMsg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:外部接口信息
 * @date: 2018-12-11 09:06
 **/
@Service
public class ExternalInterfaceMsgDomainImpl implements ExternalInterfaceMsgDomain {

    @Resource
    private ExternalInterfaceMsgDao externalInterfaceMsgDao;

    @Override
    public List<ExternalInterfaceMsg> queryListByParam(ExternalInterfaceMsg record) {
        return externalInterfaceMsgDao.queryListByParam(record);
    }

    @Override
    public List<ExternalInterfaceMsg> queryBgyInterfaceMsg(Integer msgTypeValue, Long orgId) {
        ExternalInterfaceMsg record=new ExternalInterfaceMsg();
        record.setMsgTypeValue(msgTypeValue);
        record.setOrgId(orgId);
        record.setPlatformValue(ExternalConstant.PlatformValue.INTEGERATED_PLATFORM.getValue());
        return externalInterfaceMsgDao.queryListByParam(record);
    }

    @Override
    public int insert(ExternalInterfaceMsg record) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return externalInterfaceMsgDao.insert(record);
    }

    @Override
    public int insertSelective(ExternalInterfaceMsg record) {
        record.setCreateTime(new Date());
        record.setLogicRemove(false);
        return externalInterfaceMsgDao.insertSelective(record);
    }

    @Override
    public int successInterfaceMsg(Long orgId, Integer msgType, Integer totalCount) {
        ExternalInterfaceMsg record = new ExternalInterfaceMsg();
        Date createTime=new Date();
        record.setPlatformValue(ExternalConstant.PlatformValue.INTEGERATED_PLATFORM.getValue());
        record.setOrgId(orgId);
        record.setMsgTypeValue(msgType);
        record.setTotalCount(totalCount);
        record.setAddCount(totalCount);
        record.setSuccessCount(totalCount);
        record.setErrorCount(0);
        record.setRequestTime(createTime);
        record.setCreateTime(createTime);
        record.setLogicRemove(false);
        return externalInterfaceMsgDao.insertSelective(record);
    }

    @Override
    public int alterInterfaceMsg(Long orgId, Integer msgType,Integer totalCount,Integer addCount, Integer updateCount, Integer deleteCount,Date updateTime) {
        ExternalInterfaceMsg record = new ExternalInterfaceMsg();
        Date requestTime=new Date();
        record.setPlatformValue(ExternalConstant.PlatformValue.INTEGERATED_PLATFORM.getValue());
        record.setOrgId(orgId);
        record.setMsgTypeValue(msgType);
        record.setTotalCount(totalCount);
        record.setAddCount(addCount);
        record.setUpdateCount(updateCount);
        record.setDeleteCount(deleteCount);
        record.setSuccessCount(totalCount);
        record.setErrorCount(0);
        record.setRequestTime(requestTime);
        record.setCreateTime(updateTime);
        record.setLogicRemove(false);
        return externalInterfaceMsgDao.insertSelective(record);
    }
}
