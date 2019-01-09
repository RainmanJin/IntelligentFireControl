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

    PageInfo queryListRegionProject(Page page,Long id , String keyword);

    int insert(RegionProject record);

    int updateRegionProject(RegionProject record);

    int deleteRegionProject(String str);

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


    Map<String,Object> findById( Long id );

    List<Map<String, Object>> queryByCodeSort(Long id);

    /**
     * @description:根据区域id获取区域项目
     * @param:
     * @return:
     * @auther: chenlie
     * @date: 2019/1/8 16:04
     */
    List<RegionProject> queryRegionProjectByRegionId(Long regionId);

}
