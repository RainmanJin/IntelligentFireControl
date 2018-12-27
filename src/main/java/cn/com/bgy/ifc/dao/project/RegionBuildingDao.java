package cn.com.bgy.ifc.dao.project;

import cn.com.bgy.ifc.entity.po.project.RegionBuilding;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;

import java.util.List;
import java.util.Map;

public interface RegionBuildingDao {
    int insert(RegionBuilding record);

    int insertSelective(RegionBuilding record);

    List<Map<String,Object>> queryListRegionBuilding(  RegionAndBrandVO regionAndBrandVO);


    int updateRegionBuilding(RegionBuilding record);

    int deleteRegionBuilding( List<Long> list );

    //根据Id查询楼栋名
    String queryRegionBuildingtNameById(Long id);

    //根据父级ID查询所有楼栋名
    List<Map<String,Object>> queryRegionBuildingtNameBySuperId( Long id);

    //根据父级id删除所有楼栋单元
    int deleteRegionBuildingBySuperId(List<Long> list);

}