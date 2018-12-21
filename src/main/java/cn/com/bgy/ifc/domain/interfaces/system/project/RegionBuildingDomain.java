package cn.com.bgy.ifc.domain.interfaces.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionBuilding;
import cn.com.bgy.ifc.entity.vo.system.project.RegionBuildingVo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:19
 * @Description  楼栋单元信息Donmain
 **/

public interface RegionBuildingDomain {

    List<RegionBuildingVo> queryListRegionBuilding( RegionBuildingVo record );

    int insert( RegionBuilding record );

    int updateRegionStreet( RegionBuilding record );

    int deleteRegionStreet( List<Long> list);

    List<Map<String,Object>> queryRegionBuildingtNameBySuperId( Long id);
}
