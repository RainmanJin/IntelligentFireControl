package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.RenovationRecord;

import java.util.List;
import java.util.Map;

public interface RenovationRecordDao extends BaseDao<RenovationRecord> {
    //查询备案信息（含条件查询）
    List<Map<String,Object>> queryRenovationRecordList( Map<String,Object> map );
}