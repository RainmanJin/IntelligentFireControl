package cn.com.bgy.ifc.dao.firepatrol;


import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FundsDudget;

import java.util.List;
import java.util.Map;

public interface FundsDudgetDao extends BaseDao<FundsDudget> {
    //分页查询
    List<Map<String,Object>> queryListByPage( Map<String,Object> map );
}