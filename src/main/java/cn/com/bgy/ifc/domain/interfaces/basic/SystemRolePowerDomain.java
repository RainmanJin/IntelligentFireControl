package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.SystemRolePower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemRolePowerDomain {
    int save(SystemRolePower systemRolePower);

    List<SystemRolePower> searchByWhere(SystemRolePower systemRolePower);

    PageInfo<SystemRolePower> searchByPage(Page page, SystemRolePower systemRolePower);

    int deleteById(Long id);

    SystemRolePower findById(Long id);
}
