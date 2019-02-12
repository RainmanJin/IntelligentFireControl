package cn.com.bgy.ifc.service.interfaces.inner.firepatrol;

import cn.com.bgy.ifc.entity.po.firepatrol.FundsDudget;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.Map;

/**
 * @Author huxin
 * @Date 2019/2/12 14:28
 * @Description 年度消防经费预算Service
 **/

public interface FundsDudgetService {

    //分页条件查询
    PageInfo queryListByPage( Page<Object> page, Long regionId,String keyword );
    //根据ID查询明细
    Map<String,Object> findById( Long id );
    //批量删除
    int deleteData( String ids );
    //修改
    int editData( FundsDudget fundsDudget );
    //新增
    int createData( FundsDudget fundsDudget );
}
