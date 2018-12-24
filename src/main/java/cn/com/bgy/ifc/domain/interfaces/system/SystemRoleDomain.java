package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.vo.system.SystemRoleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemRoleDomain extends BaseDomain<SystemRole> {

    PageInfo<SystemRole> queryListByPage(Page<SystemRole> page,SystemRoleVo systemRoleVo);

    List<SystemRole> queryListByParam(SystemRole record);

    int insert(SystemRole record);

    SystemRole findById(Long id);

    int updateRole(SystemRole record);

    /**
     * 根据用户id查询系统角色（下拉展示）
     * @param userId
     * @return
     */
    List<SystemRole> queryListByUserId(Long userId);

}
