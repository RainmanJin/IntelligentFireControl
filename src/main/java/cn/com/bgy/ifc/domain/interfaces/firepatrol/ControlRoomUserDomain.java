package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ControlRoomUserDomain extends BaseDomain<ControlRoomUser> {

    /**
     * 分页查询消防控制室人员列表
     * @author chenlie
     * @param page
     * @param controlRoomUser
     * @return
     */
    PageInfo<ControlRoomUser> queryListByPage(Page<ControlRoomUser> page, ControlRoomUser controlRoomUser);
    //查询值班室人员下拉列表
    List<ControlRoomUser> DropDownData();
}