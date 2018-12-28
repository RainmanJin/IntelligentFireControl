package cn.com.bgy.ifc.dao.project;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.project.RegionProject;

import java.util.List;
import java.util.Map;

public interface RegionProjectDao extends BaseDao<RegionProject> {

    List<Map<String,Object>> queryListRegionProject( Map<String,Object> map);

    int deleteRegionProject(List<Long> list);

    //根据父级ID查询所有项目名
    List<Map<String,Object>> queryRegionProjectNameBySuperId( Long id);

    //根据父级id删除所有项目
    int deleteRegionProjecBySuperId(List<Long> list);
}