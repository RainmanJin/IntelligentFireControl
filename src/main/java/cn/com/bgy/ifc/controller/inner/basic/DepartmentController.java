package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.annotation.SystemLogSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.TreeUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.DepartmentDomain;
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

    @PostMapping("query")
    @ResponseBody
    public ResponseVO<PageInfo<Department>> queryList(Page<Department> page, DepartmentVo departmentVo) {
            Department department = new Department();
            CopyUtil.copyProperties(departmentVo, department);
            PageInfo<Department> pageInfo = departmentDomain.queryListByPage(page, department);
            return ResponseVO.<PageInfo<Department>>success().setData(pageInfo);
    }

    @GetMapping("tree")
    @ResponseBody
    public ResponseVO<List<DepartmentVo>> queryTree() {
        List<Department> list = departmentDomain.queryAllList();
        System.out.println(list);
        List<DepartmentVo> functionList = new ArrayList<DepartmentVo>();
        for (Department department : list) {
            DepartmentVo departmentVo = new DepartmentVo();
            CopyUtil.copyProperties(department, departmentVo);
            functionList.add(departmentVo);
        }
        System.out.println(functionList);
        TreeUtil.getChildEntity(functionList,0L);
        System.out.println(functionList);
        return ResponseVO.<List<DepartmentVo>>success().setData(functionList);
    }

    @PostMapping("queryById/{id}")
    @ResponseBody
    public ResponseVO<DepartmentVo> queryById(@PathVariable long id) {
        Department department = departmentDomain.findById(id);
        DepartmentVo departmentVo = new DepartmentVo();
        CopyUtil.copyProperties(department, departmentVo);
        return ResponseVO.<DepartmentVo>success().setData(departmentVo);
    }

    @PostMapping("test")
    @SystemLogAfterSave(type=1,description = "部门添加")
    @ResponseBody
    public ResponseVO<Object> test() {
        System.out.println("====");
        return ResponseVO.success().setMsg("添加成功！");
    }

    /**
     * @author: ZhangCheng
     * @description:部门信息添加
     * @param: [departmentVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("add")
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
