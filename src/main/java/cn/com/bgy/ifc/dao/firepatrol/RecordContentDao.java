package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordContent;

public interface RecordContentDao extends BaseDao<RecordContent> {
    //根据记录表ID查询设施设备故障检查内容
    RecordContent queryContentByRecordId( Long recordId);
}