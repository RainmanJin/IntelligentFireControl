package cn.com.bgy.ifc.dao.project;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.project.RegionComputerRoom;
import cn.com.bgy.ifc.entity.vo.task.RegionAndBrandVO;

import java.util.List;
import java.util.Map;

public interface RegionComputerRoomDao extends BaseDao<RegionComputerRoom> {

    int insert(RegionComputerRoom record);

    int insertSelective(RegionComputerRoom record);

    int updateSelective(RegionComputerRoom record);

    List<Map<String,Object>> queryListRegionComputerRoom( RegionAndBrandVO record);

    int updateRegionComputerRoom(RegionComputerRoom record);

    int deleteRegionComputerRoom( List<Long> list );
    //传入ID查询机房信息
    RegionComputerRoom queryRegionComputerRoomById(Long id);

    //根据父级id删除所有机房
    int deleteRegionComputerRoomBySuperId(List<Long> list);
}