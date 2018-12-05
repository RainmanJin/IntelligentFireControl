package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemUserRole;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemUserRoleDomain {
    int save(SystemUserRole systemUserRole);

    List<SystemUserRole> searchByWhere(SystemUserRole systemUserRole);

    PageInfo<SystemUserRole> searchByPage(Page page, SystemUserRole systemUserRole);

    int deleteById(Long id);

    SystemUserRole findById(Long id);

    int updateById(SystemUserRole systemUserRole);
}
