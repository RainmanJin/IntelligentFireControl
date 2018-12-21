package cn.com.bgy.ifc.service.interfaces.inner.projects;

import cn.com.bgy.ifc.entity.po.system.project.RegionStreet;
import cn.com.bgy.ifc.entity.vo.system.project.RegionStreetVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 10:39
 * @Description 街道信息
 **/

public interface RegionStreetService {

    PageInfo<RegionStreetVo> queryListRegionStreet( Page<RegionStreetVo> page, RegionStreetVo record );

    int insert( RegionStreet record );

    int updateRegionStreet( RegionStreet record );

    int deleteRegionStreet( String str );

    List<Map<String,Object>> queryRegionStreetNameBySuperId( Long id);
}
