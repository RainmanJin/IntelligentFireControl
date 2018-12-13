package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.RegionInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface RegionInfoDomain {
    /**
     * 分页
     * @param regionInfo
     * @return
     */
    PageInfo<RegionInfo> searchByPage(Page page, RegionInfo regionInfo);
}
