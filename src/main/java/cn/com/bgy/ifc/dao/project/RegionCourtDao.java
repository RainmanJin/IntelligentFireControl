package cn.com.bgy.ifc.dao.project;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.project.RegionCourt;
import cn.com.bgy.ifc.entity.vo.project.RegionCourtVo;

import java.util.List;
import java.util.Map;

public interface RegionCourtDao extends BaseDao<RegionCourt> {


    List<Map<String,Object>> queryListRegionCourt( RegionCourtVo regionCourtVo);


    int updateRegionCourt(RegionCourt record);

    int deleteRegionCourt( List<Long> list );
    //根据Id查询苑区名
    String queryRegionCourtNameById(Long id);

    //根据父级ID查询所有苑区名
    List<Map<String,Object>> queryRegionCourtNameBySuperId( Long id);

    //根据父级id删除所有苑区
    int deleteRegionCourtBySuperId(List<Long> list);
}