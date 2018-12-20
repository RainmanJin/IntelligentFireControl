package cn.com.bgy.ifc.service.interfaces.inner.projects;

import cn.com.bgy.ifc.entity.po.system.project.RegionBuilding;
import cn.com.bgy.ifc.entity.vo.system.project.RegionBuildingVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 10:39
 * @Description 楼栋单元信息
 **/

public interface RegionBuildingService {

    PageInfo<RegionBuildingVo> queryListRegionBuilding( Page<RegionBuildingVo> page, RegionBuildingVo record );

    int insert( RegionBuilding record );

    int updateRegionBuilding( RegionBuilding record );

    int deleteRegionBuilding( String str );
    List<Map<String,Object>> queryRegionBuildingNameBySuperId( Long id);
}
