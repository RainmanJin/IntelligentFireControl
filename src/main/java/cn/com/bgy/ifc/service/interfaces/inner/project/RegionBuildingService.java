package cn.com.bgy.ifc.service.interfaces.inner.project;

import cn.com.bgy.ifc.entity.po.project.RegionBuilding;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;
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

    PageInfo queryListRegionBuilding( Page page, RegionAndBrandVO regionAndBrandVO  );

    int insert( RegionBuilding record );

    int updateRegionBuilding( RegionBuilding record );

    int deleteRegionBuilding( String str );
    List<Map<String,Object>> queryRegionBuildingNameBySuperId( Long id);
}
