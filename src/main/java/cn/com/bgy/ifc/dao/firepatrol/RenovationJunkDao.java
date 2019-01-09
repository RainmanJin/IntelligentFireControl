package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.RenovationJunk;

import java.util.List;
import java.util.Map;

public interface RenovationJunkDao extends BaseDao<RenovationJunk> {
    //查询装修垃圾清理情况列表
    List<Map<String,Object>> listRenovationJunk( Map<String,Object> map );
    //根据备案ID删除
    int deleteByRecordId( List<Long> list );
    //根据备案ID查询
    RenovationJunk queryByRecordId( Long recordId );
}