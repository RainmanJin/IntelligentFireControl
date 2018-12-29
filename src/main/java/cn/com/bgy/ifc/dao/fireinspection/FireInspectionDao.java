package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.FireInspection;

public interface FireInspectionDao {
    int insert(FireInspection record);

    int insertSelective(FireInspection record);
}