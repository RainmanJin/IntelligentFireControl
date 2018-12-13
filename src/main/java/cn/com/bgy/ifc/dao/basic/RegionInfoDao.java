package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.RegionInfo;

import java.util.List;

public interface RegionInfoDao {

    List<RegionInfo> searchByWhere(RegionInfo regionInfo);
}