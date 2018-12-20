package cn.com.bgy.ifc.dao.system.basic;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.basic.ExternalInterfaceMsg;

import java.util.List;

public interface ExternalInterfaceMsgDao extends BaseDao<ExternalInterfaceMsg> {

    List<ExternalInterfaceMsg> queryListByParam(ExternalInterfaceMsg record);

}