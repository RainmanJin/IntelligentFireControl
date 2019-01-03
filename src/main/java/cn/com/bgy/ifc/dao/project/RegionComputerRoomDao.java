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

    //根据区域ID、项目ID、苑区ID、街道ID、楼栋单元ID修改所属地址
    int updateFindByAddressId(Map<String,Object> map);
}