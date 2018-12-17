package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.domain.interfaces.basic.DepartmentDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.UserPowerDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.po.basic.UserPower;
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
@RequestMapping("/basic/userPower")
public class UserPowerController {
    @Autowired
    private UserPowerDomain userPowerDomain;

    @Autowired
    private DepartmentDomain departmentDomain;
    /**
     * 分页查询
     *用户权限展示页面
     * @param userPower
     * @return
     */
    @PostMapping ("/queryPageList")
    @ResponseBody
    public ResponseVO<Object> queryPageList(UserPower userPower) {
        Page page = new Page();
        page.setPageSize(userPower.getPageSize());
        page.setPageNum(userPower.getPageNum());
        PageInfo<UserPower> pageInfo = userPowerDomain.queryPageList(page,userPower);
        return ResponseVO.success().setData(pageInfo);
    }
    /**
     *查询部门名称
     * @return
     */
    @GetMapping("getDpartmentName")
    @ResponseBody
    public ResponseVO<Object> getModelName() {
        List<Department> list = departmentDomain.queryAllList();
        return ResponseVO.success().setData(list);
    }
}
