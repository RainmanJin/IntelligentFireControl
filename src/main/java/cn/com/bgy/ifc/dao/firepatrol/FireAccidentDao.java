package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FireAccident;

public interface FireAccidentDao extends BaseDao<FireAccident> {
    /**
     *
     * @mbg.generated 2019-01-05
     */
    int insert(FireAccident record);

    /**
     *
     * @mbg.generated 2019-01-05
     */
    int insertSelective(FireAccident record);
}