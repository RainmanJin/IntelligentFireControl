package cn.com.bgy.ifc.domain.interfaces.firepatrol;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.firepatrol.FireBrigade;
import cn.com.bgy.ifc.entity.po.firepatrol.FireRehearse;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface FireRehearseDomain extends BaseDomain<FireRehearse> {

    /**
     * 分页查询消防演练及宣传
     * @author chenle
     * @param page
     * @param fireRehearse
     * @return
     */
    PageInfo<FireRehearse> queryListByPage(Page<FireRehearse> page, FireRehearse fireRehearse);
}