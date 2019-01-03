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

    //根据区域ID、项目ID、苑区ID、街道ID、楼栋单元ID修改所属地址
    int updateFindByAddressId(Map<String,Object> map);
}