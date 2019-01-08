package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse;

public interface FireRehearseDao extends BaseDao<FireRehearse> {
    /**
     *
     * @mbg.generated 2019-01-07
     */
    int insert(FireRehearse record);

    /**
     *
     * @mbg.generated 2019-01-07
     */
    int insertSelective(FireRehearse record);
}