package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.SystemPower;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SystemPowerDomain {

    PageInfo<SystemPower> queryListByPage(Page<SystemPower> page, SystemPower record);

    List<SystemPower> queryListByParam(SystemPower record);

    int insert(SystemPower record);

    SystemPower findById(Long id);

    int update(SystemPower record);

    int deleteById(Long id);

    List<SystemPower> queryListByUserId(Long userId);

}