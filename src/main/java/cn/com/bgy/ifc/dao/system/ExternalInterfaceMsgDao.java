package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.ExternalInterfaceMsg;

import java.util.List;

public interface ExternalInterfaceMsgDao extends BaseDao<ExternalInterfaceMsg> {

    List<ExternalInterfaceMsg> queryListByParam(ExternalInterfaceMsg record);

}