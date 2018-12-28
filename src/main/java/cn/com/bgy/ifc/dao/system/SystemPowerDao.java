package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.SystemPower;

import java.util.List;

public interface SystemPowerDao extends BaseDao<SystemPower> {

    List<SystemPower> queryListByPage(String keywords);

    List<SystemPower> queryListByUserId(Long userId);
}