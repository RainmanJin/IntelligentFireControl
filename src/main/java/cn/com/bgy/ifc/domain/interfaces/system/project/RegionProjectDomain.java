package cn.com.bgy.ifc.domain.interfaces.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.projects.BgyProjectVo;
import cn.com.bgy.ifc.entity.vo.system.project.RegionProjectVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Author huxin
 * @Date 2018/12/18 17:17
 * @Description
 **/

public interface RegionProjectDomain {

    PageInfo<RegionProjectVo> queryListRegionProjec(Page<RegionProjectVo> page, RegionProjectVo record);

    int insert(RegionProject record);

    int updateRegionProjec(RegionProject record);

    int deleteRegionProjec(String str);

    List<Map<String, Object>> queryRegionProjectNameBySuperId(Long id);

    /**
     * 集成平台全量增加项目信息
     *
     * @param list
     * @param orgId
     * @return
     */
    ResponseVO<Object> saveBgyRegionProject(List<BgyProjectVo> list, Long orgId);

    /**
     * 集成平台增量增加项目信息
     *
     * @param list
     * @param orgId
     * @return
     */
    ResponseVO<Object> alterBgyRegionProject(List<BgyProjectVo> list, Long orgId);
}
