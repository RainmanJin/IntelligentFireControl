package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.RegionComputerRoom;

public interface RegionComputerRoomDao {
    int insert(RegionComputerRoom record);

    int insertSelective(RegionComputerRoom record);
}