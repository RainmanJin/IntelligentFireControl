package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.RenovationRecord;

public interface RenovationRecordDao {
    int insert(RenovationRecord record);

    int insertSelective(RenovationRecord record);
}