package cn.com.bgy.ifc.dao.basic;

import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.po.basic.SystemPower;

import java.util.List;

public interface DepartmentDao {

    List<Department> queryAllList();

    List<Department> queryListByParam(Department record);

    Department findById(Long id);

    int deleteById(Long id);

    int insert(Department record);

    int insertSelective(Department record);

    int update(Department record);

    int deleteBatchById(List<Long> ids);
}