package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.system.project.RegionInfoVo;

import java.util.List;

public interface RegionInfoDao extends BaseDao<RegionInfo> {

    List<RegionInfo> queryListRegionInfo(RegionInfoVo regionInfoVo);

    int updateRegionInfo(RegionInfoVo record);

    int deleteRegionInfo(List<Long> list);
}