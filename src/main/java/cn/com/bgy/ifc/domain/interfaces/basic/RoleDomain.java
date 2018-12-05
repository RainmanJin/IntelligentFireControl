package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleDomain {

    PageInfo<SystemRole> queryListByPage(Page<SystemRole> page, SystemRole record);

    List<SystemRole> queryListByParam(SystemRole record);

    int insert(SystemRole record);

    SystemRole findById(Long id);

    int update(SystemRole record);

    int deleteById(Long id);
}
