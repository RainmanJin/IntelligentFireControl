package cn.com.bgy.ifc.service.interfaces.inner.project;

import cn.com.bgy.ifc.entity.po.project.RegionCourt;
import cn.com.bgy.ifc.entity.vo.system.project.RegionCourtVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/19 10:39
 * @Description 区域苑区信息
 **/

public interface RegionCourtService {

    PageInfo<RegionCourtVo> queryListRegionCourt( Page<RegionCourtVo> page, RegionCourtVo regionCourtVo);

    int insert(RegionCourt record);

    int updateRegionCourt(RegionCourt record);

    int deleteRegionCourt(String str);

    List<Map<String,Object>> queryRegionCourtNameBySuperId( Long id);
}
