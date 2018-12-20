package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionComputerRoom;

public interface RegionComputerRoomDao {

    int insert(RegionComputerRoom record);

    int insertSelective(RegionComputerRoom record);

    int updateSelective(RegionComputerRoom record);
}