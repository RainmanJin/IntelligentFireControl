package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionCourt;
import cn.com.bgy.ifc.entity.vo.system.project.RegionCourtVo;

import java.util.List;

public interface RegionCourtDao {
    int insert(RegionCourt record);

    int insertSelective(RegionCourt record);

    List<RegionCourtVo> queryListRegionCourt( RegionCourtVo regionCourtVo);


    int updateRegionCourt(RegionCourt record);

    int deleteRegionCourt( List<Long> list );
}