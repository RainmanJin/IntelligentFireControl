package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.system.SystemPower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemPowerDomain extends BaseDomain<SystemPower> {

    PageInfo<SystemPower> queryListByPage(Page<SystemPower> page, SystemPower record);

    int deleteById(Long id);

    List<SystemPower> queryListByUserId(Long userId);

}
