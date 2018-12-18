package cn.com.bgy.ifc.dao.basic.region;

import cn.com.bgy.ifc.entity.po.basic.region.RegionProject;
import cn.com.bgy.ifc.entity.vo.basic.region.RegionProjectVo;

import java.util.List;

public interface RegionProjectDao {
    int insert(RegionProject record);

    int insertSelective(RegionProject record);

    List<RegionProject> queryListRegionProject( RegionProjectVo record);

    int updateRegionProject(RegionProject record);

    int deleteRegionProject(List<Long> list);
}