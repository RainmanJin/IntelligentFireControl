package cn.com.bgy.ifc.domain.interfaces.basic.region;

import cn.com.bgy.ifc.entity.po.basic.region.RegionProject;
import cn.com.bgy.ifc.entity.vo.basic.region.RegionProjectVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @Author huxin
 * @Date 2018/12/18 17:17
 * @Description
 **/

public interface RegionProjectDomain {

    PageInfo<RegionProject> queryListRegionProjec( Page<RegionProject> page, RegionProjectVo record);

    int insert(RegionProject record);

    int updateRegionProjec(RegionProject record);

    int deleteRegionProjec(String str);
}
