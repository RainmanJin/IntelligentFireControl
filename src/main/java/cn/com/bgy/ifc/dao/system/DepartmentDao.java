package cn.com.bgy.ifc.dao.system;

import cn.com.bgy.ifc.dao.base.BaseDao;
import cn.com.bgy.ifc.entity.po.system.Department;
import cn.com.bgy.ifc.entity.vo.system.DepartmentVo;

import java.util.List;

public interface DepartmentDao extends BaseDao<Department> {

    List<Department> queryAllList();

    List<Department> queryListByParam(Department record);

    /**
     * YanXiaoLu
     * 根据当前用户查询父级部门名称（前端下拉展示）
     * @param userId
     * @return
     */
    List<Department> findParentNameByUserId(Long userId);

}