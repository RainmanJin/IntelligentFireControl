package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser;

public interface ControlRoomUserDao extends BaseDao<ControlRoomUser> {
    /**
     *
     * @mbg.generated 2019-01-07
     */
    int insert(ControlRoomUser record);

    /**
     *
     * @mbg.generated 2019-01-07
     */
    int insertSelective(ControlRoomUser record);
}