package cn.com.bgy.ifc.domain.interfaces.system.project;

import cn.com.bgy.ifc.entity.po.system.project.RegionProject;
import cn.com.bgy.ifc.entity.vo.system.project.RegionProjectVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @Author huxin
 * @Date 2018/12/18 17:17
 * @Description
 **/

public interface RegionProjectDomain {

    PageInfo<RegionProject> queryListRegionProjec( Page<RegionProject> page, RegionProjectVo record);

    int insert(RegionProject record);

    int updateRegionProjec(RegionProject record);

    int deleteRegionProjec(String str);
}
