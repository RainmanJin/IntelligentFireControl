package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FacilityProtection;

import java.util.List;
import java.util.Map;

public interface FacilityProtectionDao extends BaseDao<FacilityProtection> {

    //查询消防设施保护情况列表
    List<Map<String,Object>> listFacilityProtection( Map<String,Object> map );
    //根据备案ID删除
    int deleteByRecordId( List<Long> list );
    //根据备案ID查询附近是否存在消防设施
    FacilityProtection queryByRecordId( Long id );
}