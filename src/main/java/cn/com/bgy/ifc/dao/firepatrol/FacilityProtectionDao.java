package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.FacilityProtection;

public interface FacilityProtectionDao {
    int insert(FacilityProtection record);

    int insertSelective(FacilityProtection record);
}