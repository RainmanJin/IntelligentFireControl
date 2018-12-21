package cn.com.bgy.ifc.controller.inner.system.user;

import cn.com.bgy.ifc.domain.interfaces.system.user.DepartmentDomain;
import cn.com.bgy.ifc.domain.interfaces.system.user.UserRoleDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.po.system.user.UserRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/basic/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleDomain userRoleDomain;

    @Autowired
    private DepartmentDomain departmentDomain;

    /**
     * 分页查询用户角色列表（前端页面展示）
     * @param page
     * @param userRole
     * @return
     */
    @PostMapping("/queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(Page<Object> page, UserRole userRole) {
        PageInfo<UserRole> pageInfo = userRoleDomain.queryPageList(page, userRole);
        return ResponseVO.success().setData(pageInfo);
    }

    /**
     * 查询部门名称
     * @return
     */
    @GetMapping("getDpartmentName")
    @ResponseBody
    public ResponseVO<Object> getModelName() {
        List<Department> list = departmentDomain.queryAllList();
        return ResponseVO.success().setData(list);
    }
}
