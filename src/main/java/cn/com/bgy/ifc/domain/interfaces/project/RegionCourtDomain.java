package cn.com.bgy.ifc.domain.interfaces.project;

import cn.com.bgy.ifc.entity.po.project.RegionCourt;
import cn.com.bgy.ifc.entity.vo.project.RegionCourtVo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:19
 * @Description  区域苑区信息Donmain
 **/

public interface RegionCourtDomain {

    List<RegionCourtVo> queryListRegionCourt( RegionCourtVo regionCourtVo);

    int insert(RegionCourt record);

    int updateRegionCourt(RegionCourt record);

    int deleteRegionCourt(List<Long> list);

    List<Map<String,Object>> queryRegionCourtNameBySuperId( Long id);

}
