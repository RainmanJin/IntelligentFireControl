package cn.com.bgy.ifc.domain.impl.basic;

import cn.com.bgy.ifc.dao.basic.ExternalInterfaceMsgDao;
import cn.com.bgy.ifc.domain.interfaces.basic.ExternalInterfaceMsgDomain;
import cn.com.bgy.ifc.entity.po.basic.ExternalInterfaceMsg;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public int insert(ExternalInterfaceMsg record) {
        return externalInterfaceMsgDao.insert(record);
    }

    @Override
    public int insertSelective(ExternalInterfaceMsg record) {
        return externalInterfaceMsgDao.insertSelective(record);
    }
}
