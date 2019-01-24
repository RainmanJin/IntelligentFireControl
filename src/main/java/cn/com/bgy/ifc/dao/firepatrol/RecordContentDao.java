package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordContent;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;

import java.util.List;
import java.util.Map;

public interface RecordContentDao extends BaseDao<RecordContent> {
    //根据记录表ID查询记录内容
    RecordContent queryContentByRecordId( Long recordId);
    //根据类型ID查询记录内容
    List<RecordTable> dropDownDataFindByEquipmentTypeId(  Map<String,Object> map);
}