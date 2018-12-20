package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.system.project.RegionProjectVo;

import java.util.List;
import java.util.Map;

public interface RegionProjectDao {
    int insert(RegionProject record);

    int insertSelective(RegionProject record);

    List<RegionProjectVo> queryListRegionProject( RegionProjectVo record);

    int updateRegionProject(RegionProject record);

    int deleteRegionProject(List<Long> list);

    //根据父级ID查询所有项目名
    List<Map<String,Object>> queryRegionProjectNameBySuperId( Long id);

    //根据父级id删除所有项目
    int deleteRegionProjecBySuperId(List<Long> list);
}