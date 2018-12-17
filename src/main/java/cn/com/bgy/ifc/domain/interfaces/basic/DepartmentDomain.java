package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Department;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DepartmentDomain {

    PageInfo<Department> queryListByPage(Page<Department> page, Department department);

    List<Department> queryListByParam(Department department);

    List<Department> queryAllList();

    Department findById(Long id);

    int deleteById(Long id);

    int insert(Department department);

    int update(Department department);

    int deleteBatchById(List<Long> ids);

}
