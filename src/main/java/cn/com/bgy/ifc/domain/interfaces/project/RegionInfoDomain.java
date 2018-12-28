package cn.com.bgy.ifc.domain.interfaces.project;

import cn.com.bgy.ifc.entity.po.project.RegionInfo;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.BgyRegionInfoVo;
import cn.com.bgy.ifc.entity.vo.project.RegionInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface RegionInfoDomain {

    PageInfo queryListRegionInfo(Page page, String keyword,Account user);

    int insert(RegionInfo record);

    int updateRegionInfo(RegionInfoVo record);

    int deleteRegionInfo(String ids);

    List<Map<String, Object>> queryRegionInfoName(Account user);

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
