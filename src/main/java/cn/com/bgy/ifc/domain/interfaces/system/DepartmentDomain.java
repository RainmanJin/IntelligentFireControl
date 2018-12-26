package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.domain.interfaces.base.BaseDomain;
import cn.com.bgy.ifc.entity.po.system.Department;
import cn.com.bgy.ifc.entity.vo.system.DepartmentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DepartmentDomain extends BaseDomain<Department> {

    PageInfo<Department> queryListByPage(Page<Department> page, Department department);

    List<Department> queryListByParam(Department department);

    List<Department> queryAllList();

    Department findById(Long id);

    int insert(Department department);

    int update(Department department);
    /**
     * YanXiaoLu
     * 根据当前用户查询父级部门名称（前端下拉展示）
     * @param userId
     * @return
     */
     List<Department> findParentNameByUserId(Long userId);

}
