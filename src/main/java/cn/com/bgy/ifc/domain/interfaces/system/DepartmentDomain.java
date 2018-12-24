package cn.com.bgy.ifc.domain.interfaces.system;

import cn.com.bgy.ifc.entity.po.system.Department;
import cn.com.bgy.ifc.entity.vo.system.DepartmentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface DepartmentDomain {

    PageInfo<DepartmentVo> queryListByPage(Page<DepartmentVo> page, DepartmentVo departmentVo);

    List<Department> queryListByParam(DepartmentVo departmentVo);

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
