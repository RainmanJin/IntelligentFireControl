package cn.com.bgy.ifc.dao.project;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.project.RegionBuilding;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;

import java.util.List;
import java.util.Map;

public interface RegionBuildingDao extends BaseDao<RegionBuilding> {


    List<Map<String,Object>> queryListRegionBuilding(  RegionAndBrandVO regionAndBrandVO);


    int updateRegionBuilding(RegionBuilding record);

    int deleteRegionBuilding( List<Long> list );

    //根据Id查询楼栋名
    String queryRegionBuildingtNameById(Long id);

    //根据父级ID查询所有楼栋名
    List<Map<String,Object>> queryRegionBuildingtNameBySuperId( Long id);

    //根据区域ID、项目ID、苑区ID、街道ID、楼栋单元ID修改所属地址
    int updateFindByAddressId(Map<String,Object> map);

}