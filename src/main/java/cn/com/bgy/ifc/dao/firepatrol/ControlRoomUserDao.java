package cn.com.bgy.ifc.dao.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser;

import java.util.List;

public interface ControlRoomUserDao extends BaseDao<ControlRoomUser> {
    //查询值班室人员下拉列表
    List<ControlRoomUser> DropDownData();
}