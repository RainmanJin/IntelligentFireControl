package cn.com.bgy.ifc.dao.fireinspection;

import cn.com.bgy.ifc.entity.po.fireinspection.FireInspectionDetail;

public interface FireInspectionDetailDao {
    int insert(FireInspectionDetail record);

    int insertSelective(FireInspectionDetail record);
}