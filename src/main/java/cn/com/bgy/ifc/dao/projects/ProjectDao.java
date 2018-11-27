package cn.com.bgy.ifc.dao.projects;

import cn.com.bgy.ifc.entity.po.projects.Project;

public interface ProjectDao {
    int insert(Project record);

    int insertSelective(Project record);
}