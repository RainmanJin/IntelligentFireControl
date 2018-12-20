package cn.com.bgy.ifc.controller.inner.system.user;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.TreeUtil;
import cn.com.bgy.ifc.domain.interfaces.system.user.DepartmentDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.DepartmentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ZhangCheng
 * @description:部门管理
 * @date: 2018-12-05 09:30
 **/
@Controller
@RequestMapping("/basic/department")
public class DepartmentController {
    @Autowired
    private DepartmentDomain departmentDomain;

    /**
     * @author: ZhangCheng
     * @description:查询部门信息列表
     * @param: [page, departmentVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<com.github.pagehelper.PageInfo<cn.com.bgy.ifc.entity.po.basic.Department>>
     */
    @PostMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo<DepartmentVo>> queryList(Page<DepartmentVo> page, DepartmentVo departmentVo) {
            PageInfo<DepartmentVo> pageInfo = departmentDomain.queryListByPage(page, departmentVo);
            return ResponseVO.<PageInfo<DepartmentVo>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:查询部门树
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.util.List<cn.com.bgy.ifc.entity.vo.basic.DepartmentVo>>
     */
    @GetMapping("tree")
    @ResponseBody
    public ResponseVO<List<DepartmentVo>> queryTree(String token) {
        List<Department> list = departmentDomain.queryAllList();
        List<DepartmentVo> functionList = new ArrayList<DepartmentVo>();
        for (Department department : list) {
            DepartmentVo departmentVo = new DepartmentVo();
            CopyUtil.copyProperties(department, departmentVo);
            functionList.add(departmentVo);
        }
        List<DepartmentVo> treeList =TreeUtil.switchTree(functionList,0L);
        return ResponseVO.<List<DepartmentVo>>success().setData(treeList);
    }

    /**
     * @author: ZhangCheng
     * @description:上级部门查询
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.util.List<cn.com.bgy.ifc.entity.po.basic.Department>>
     */
    @GetMapping("queryList")
    @ResponseBody
    public ResponseVO<List<Department>> queryList() {
        DepartmentVo departmentVo = new DepartmentVo();
        departmentVo.setState(SystemConstant.EnableState.ENABLE.getValue());
        List<Department> list = departmentDomain.queryListByParam(departmentVo);
        return ResponseVO.<List<Department>>success().setData(list);
    }

    @PostMapping("queryById/{id}")
    @ResponseBody
    public ResponseVO<DepartmentVo> queryById(@PathVariable long id) {
        Department department = departmentDomain.findById(id);
        DepartmentVo departmentVo = new DepartmentVo();
        CopyUtil.copyProperties(department, departmentVo);
        return ResponseVO.<DepartmentVo>success().setData(departmentVo);
    }

    /**
     * @author: ZhangCheng
     * @description:部门信息添加
     * @param: [departmentVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "部门信息添加")
    @ResponseBody
    public ResponseVO<Object> add(@Validated DepartmentVo departmentVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        Department department = new Department();
        CopyUtil.copyProperties(departmentVo, department);
        int count = departmentDomain.insert(department);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功！");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }

    /**
     * @author: ZhangCheng
     * @description:部门信息修改
     * @param: [departmentVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("edit")
    @SystemLogAfterSave(type = 1,description = "部门信息修改")
    @ResponseBody
    public ResponseVO<Object> edit(@Validated DepartmentVo departmentVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        Department department = new Department();
        CopyUtil.copyProperties(departmentVo, department);
        int count = departmentDomain.update(department);
        if (count == 1) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }

    /**
     * @author: ZhangCheng
     * @description:部门启用禁用操作
     * @param: [id, state]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("prohibit")
    @ResponseBody
    public ResponseVO<Object> prohibit(Department department) {
        int count = departmentDomain.update(department);
        if (count == 1) {
            return ResponseVO.success().setMsg("操作成功");
        }
        return ResponseVO.error().setMsg("操作失败！");
    }

    /**
     * @author: ZhangCheng
     * @description:部门信息删除
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseVO<Object> delete(@PathVariable long id) {
        int count = departmentDomain.deleteById(id);
        if (count == 1) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败！");
    }



}
