package cn.com.bgy.ifc.dao.basic.region;

import cn.com.bgy.ifc.entity.po.basic.region.RegionInfo;
import cn.com.bgy.ifc.entity.vo.basic.region.RegionInfoVo;

import java.util.List;

public interface RegionInfoDao {

    List<RegionInfo> queryListRegionInfo(RegionInfoVo regionInfoVo);

    int insert(RegionInfo record);

    int updateRegionInfo(RegionInfoVo record);

    int deleteRegionInfo(List<Long> list);
}