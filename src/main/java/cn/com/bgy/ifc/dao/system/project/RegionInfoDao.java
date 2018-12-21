package cn.com.bgy.ifc.dao.system.project;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.system.project.RegionInfoVo;

import java.util.List;
import java.util.Map;

public interface RegionInfoDao extends BaseDao<RegionInfo> {

    List<RegionInfo> queryListRegionInfo(RegionInfoVo regionInfoVo);

    int updateRegionInfo(RegionInfoVo record);

    int deleteRegionInfo(List<Long> list);

    List<Map<String, Object>> queryRegionInfoName();

    /**
     * @author: ZhangCheng
     * @description:通过机构ID获取区域信息
     * @param: [orgId]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.system.project.RegionInfo>
     */
    List<RegionInfo> findByOrgId(Long orgId);
}