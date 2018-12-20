package cn.com.bgy.ifc.domain.interfaces.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionInfo;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyRegionInfoVo;
import cn.com.bgy.ifc.entity.vo.system.project.RegionInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface RegionInfoDomain {

    PageInfo<RegionInfo> queryListRegionInfo(Page<RegionInfo> page, RegionInfoVo systemRoleVo);

    int insert(RegionInfo record);

    int updateRegionInfo(RegionInfoVo record);

    int deleteRegionInfo(String str);

    List<Map<String, Object>> queryRegionInfoName();

    /**
     * 集成平台全量增加区域信息
     * @param list
     * @param orgId
     * @return
     */
    ResponseVO<Object> saveBgyRegionInfo(List<BgyRegionInfoVo> list, Long orgId);

    /**
     * 集成平台增量增加区域信息
     *
     * @param list
     * @param orgId
     * @return
     */
    ResponseVO<Object> alterBgyRegionInfo(List<BgyRegionInfoVo> list, Long orgId);
}
