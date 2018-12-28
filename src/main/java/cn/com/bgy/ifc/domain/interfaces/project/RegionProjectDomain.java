package cn.com.bgy.ifc.domain.interfaces.project;

import cn.com.bgy.ifc.entity.po.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.project.BgyProjectVo;
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

    PageInfo queryListRegionProjec(Page page,Long id , String keyword);

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
