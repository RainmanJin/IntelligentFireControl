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
     * @author: ZhangCheng
     * @description:通过机构ID获取区域信息
     * @param: [orgId]
     * @return: java.util.List<cn.com.bgy.ifc.entity.po.system.project.RegionInfo>
     */
    List<RegionInfo> findByOrgId(Long orgId);

    /**
     * @author: ZhangCheng
     * @description:集成平台全量增加区域信息
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> saveBgyRegionInfo(List<BgyRegionInfoVo> list, Long orgId);

    /**
     * @author: ZhangCheng
     * @description:集成平台增量增加区域信息
     * @param: [list, orgId]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    ResponseVO<Object> alterBgyRegionInfo(List<BgyRegionInfoVo> list, Long orgId);
}
