package cn.com.bgy.ifc.domain.interfaces.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.system.project.RegionInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

public interface RegionInfoDomain {

    PageInfo<RegionInfo> queryListRegionInfo( Page<RegionInfo> page, RegionInfoVo systemRoleVo);

    int insert(RegionInfo record);

    int updateRegionInfo(RegionInfoVo record);

    int deleteRegionInfo(String str);
}
