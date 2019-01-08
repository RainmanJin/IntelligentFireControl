package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade;

public interface FireBrigadeDao extends BaseDao<FireBrigade> {
    /**
     *
     * @mbg.generated 2019-01-07
     */
    int insert(FireBrigade record);

    /**
     *
     * @mbg.generated 2019-01-07
     */
    int insertSelective(FireBrigade record);
}