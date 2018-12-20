package cn.com.bgy.ifc.dao.system.user;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.vo.basic.DepartmentVo;

import java.util.List;

public interface DepartmentDao extends BaseDao<Department> {

    List<Department> queryAllList();

    List<Department> queryListByParam(DepartmentVo record);

}