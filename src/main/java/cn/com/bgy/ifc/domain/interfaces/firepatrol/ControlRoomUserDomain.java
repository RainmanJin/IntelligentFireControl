package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface ControlRoomUserDomain extends BaseDomain<ControlRoomUser> {
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

    /**
     * 分页查询消防控制室人员列表
     * @author chenlie
     * @param page
     * @param controlRoomUser
     * @return
     */
    PageInfo<ControlRoomUser> queryListByPage(Page<ControlRoomUser> page, ControlRoomUser controlRoomUser);
}