package cn.com.bgy.ifc.dao.project;

import cn.com.bgy.ifc.entity.po.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.system.project.RegionStreetVo;

import java.util.List;
import java.util.Map;

public interface RegionStreetDao {
    int insert(RegionStreet record);

    int insertSelective(RegionStreet record);

    List<RegionStreetVo> queryListRegionStreet( RegionStreetVo record);


    int updateRegionStreet(RegionStreet record);

    int deleteRegionStreet( List<Long> list );

    //根据Id查询街道名
    String queryRegionStreetNameById(Long id);

    //根据父级ID查询所有街道名
    List<Map<String,Object>> queryRegionStreetNameBySuperId(Long id);

    //根据父级id删除所有街道
    int deleteRegionStreetBySuperId(List<Long> list);
}