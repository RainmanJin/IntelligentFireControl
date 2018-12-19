package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.system.project.RegionProjectVo;

import java.util.List;

public interface RegionProjectDao {
    int insert(RegionProject record);

    int insertSelective(RegionProject record);

    List<RegionProject> queryListRegionProject( RegionProjectVo record);

    int updateRegionProject(RegionProject record);

    int deleteRegionProject(List<Long> list);
}