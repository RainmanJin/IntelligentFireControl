package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.ControlRoomUser;
import cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface FireBrigadeDomain extends BaseDomain<FireBrigade> {

    /**
     * 分页查询义务消防队建设情况
     * @author chenlie
     * @param page
     * @param fireBrigade
     * @return
     */
    PageInfo<FireBrigade> queryListByPage(Page<FireBrigade> page, FireBrigade fireBrigade);
}