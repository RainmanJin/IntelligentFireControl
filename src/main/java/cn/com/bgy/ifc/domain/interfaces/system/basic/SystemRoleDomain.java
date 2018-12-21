package cn.com.bgy.ifc.domain.interfaces.system.basic;

import cn.com.bgy.ifc.entity.po.system.basic.SystemRole;
import cn.com.bgy.ifc.entity.vo.system.basic.SystemRoleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemRoleDomain {

    PageInfo<SystemRole> queryListByPage(Page<SystemRole> page,SystemRoleVo systemRoleVo);

    List<SystemRole> queryListByParam(SystemRole record);

    int insert(SystemRole record);

    SystemRole findById(Long id);

    int updateRole(SystemRole record);

    int deleteById(Long id);
    /**
     * 逻辑删除系统角色（批量）
     * @param longs
     */
    void  deleteRole(Long[] longs);

    /**
     * 根据用户id查询系统角色（下拉展示）
     * @param userId
     * @return
     */
    List<SystemRole> queryListByUserId(Long userId);

}
