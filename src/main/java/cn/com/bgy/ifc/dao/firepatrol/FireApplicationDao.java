package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FireApplication;

import java.util.List;
import java.util.Map;

public interface FireApplicationDao extends BaseDao<FireApplication> {

    //查询动火证申请情况列表（含条件查询）
    List<Map<String,Object>> listFireApplication( Map<String,Object> map );
    //根据备案ID删除
    int deleteByRecordId( List<Long> list );
    //根据备案ID查询是否存在动火证申请情况数据
    FireApplication queryByRecordId( Long id );
}