package cn.com.bgy.ifc.domain.interfaces.project;

import cn.com.bgy.ifc.entity.po.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.project.RegionStreetVo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 9:19
 * @Description  区域苑区信息Donmain
 **/

public interface RegionStreetDomain {

    List<RegionStreetVo> queryListRegionStreet( RegionStreetVo record );

    int insert( RegionStreet record );

    int updateRegionStreet( RegionStreet record );

    int deleteRegionStreet( List<Long> list );

    List<Map<String,Object>> queryRegionStreetNameBySuperId( Long id);

}
