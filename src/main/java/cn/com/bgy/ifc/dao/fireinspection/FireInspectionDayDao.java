package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDay;

public interface FireInspectionDayDao {
    int insert(FireInspectionDay record);

    int insertSelective(FireInspectionDay record);
}