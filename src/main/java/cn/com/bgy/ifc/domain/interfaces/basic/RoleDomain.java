package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemRole;
import cn.com.bgy.ifc.entity.vo.basic.SystemRoleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface RoleDomain {

    PageInfo<SystemRole> queryListByPage(Page<SystemRole> page,SystemRoleVo systemRoleVo);

    List<SystemRole> queryListByParam(SystemRole record);

    int insert(SystemRole record);

    SystemRole findById(Long id);

    int updateRole(SystemRole record);

    int deleteById(Long id);

    int deleteRole(String str);


}
