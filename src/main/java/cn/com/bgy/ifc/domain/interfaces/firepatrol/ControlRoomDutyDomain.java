package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomDuty;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface ControlRoomDutyDomain extends BaseDomain<ControlRoomDuty> {

    /**
     * 分页查询消防监控室值班情况
     * @author chenlie
     * @param page
     * @param controlRoomDuty
     * @return
     */
    PageInfo<ControlRoomDuty> queryListByPage(Page<ControlRoomDuty> page, ControlRoomDuty controlRoomDuty,String keyword);
}