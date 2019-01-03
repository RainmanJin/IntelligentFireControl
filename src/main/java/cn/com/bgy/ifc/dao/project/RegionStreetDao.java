package cn.com.bgy.ifc.dao.project;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.project.RegionStreetVo;

import java.util.List;
import java.util.Map;

public interface RegionStreetDao extends BaseDao<RegionStreet> {


    List<Map<String,Object>> queryListRegionStreet( RegionStreetVo record);


    int updateRegionStreet(RegionStreet record);

    int deleteRegionStreet( List<Long> list );

    //根据Id查询街道名
    String queryRegionStreetNameById(Long id);

    //根据父级ID查询所有街道名
    List<Map<String,Object>> queryRegionStreetNameBySuperId(Long id);


    //根据区域ID、项目ID、苑区ID、街道ID、楼栋单元ID修改所属地址
    int updateFindByAddressId(Map<String,Object> map);
}