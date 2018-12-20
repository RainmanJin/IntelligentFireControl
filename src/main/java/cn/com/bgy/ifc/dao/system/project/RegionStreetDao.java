package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.system.project.RegionStreetVo;

import java.util.List;

public interface RegionStreetDao {
    int insert(RegionStreet record);

    int insertSelective(RegionStreet record);

    List<RegionStreetVo> queryListRegionStreet( RegionStreetVo record);


    int updateRegionStreet(RegionStreet record);

    int deleteRegionStreet( List<Long> list );
}