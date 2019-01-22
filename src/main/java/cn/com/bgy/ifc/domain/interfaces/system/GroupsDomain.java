package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.system.Groups;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface GroupsDomain extends BaseDomain<Groups> {

    PageInfo<Groups> queryListByPage(Page<Groups> page,Groups groups);

    int insertWithRegionAndProject(Groups groups,List<Long> idList);
}