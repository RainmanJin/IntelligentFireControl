package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.RecordTable;

import java.util.List;
import java.util.Map;

public interface RecordTableDao extends BaseDao<RecordTable> {
    //查询设施故障巡检
    List<Map<String,Object>> listFaultDetection( Map<String,Object> map );
    //根据设备ID查询故障检测内容下拉列表
    List<RecordTable> dropDownDataFindByEquipmentId(Map<String,Object> map);
}