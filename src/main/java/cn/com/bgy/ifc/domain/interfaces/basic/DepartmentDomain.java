package cn.com.bgy.ifc.domain.interfaces.basic;

import cn.com.bgy.ifc.entity.po.basic.Department;

import java.util.List;

public interface DepartmentDomain {

    public Department findById(Long id);

    public int deleteById(Long id);

    public int insert(Department department);

    public int update(Department department);

    public int deleteBatchById(List<Long> ids);
}
