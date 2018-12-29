package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.FireHiddenDanger;

public interface FireHiddenDangerDao {
    int insert(FireHiddenDanger record);

    int insertSelective(FireHiddenDanger record);
}