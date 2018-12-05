package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.DepartmentDomain;
import cn.com.bgy.ifc.entity.po.basic.Department;
import cn.com.bgy.ifc.entity.po.basic.SystemOperationLog;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.DepartmentVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("queryList")
    @ResponseBody
    public ResponseVO<PageInfo<Department>> queryUserList(Page<Department> page,DepartmentVo departmentVo) {
        try {
            Department department = new Department();
            CopyUtil.copyProperties(departmentVo, department);
            PageInfo<Department> pageInfo = departmentDomain.queryListByPage(page,department);
            return ResponseVO.<PageInfo<Department>>success().setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.<PageInfo<Department>>exception();
        }
    }

    @GetMapping("queryById/{id}")
    @ResponseBody
    public ResponseVO<DepartmentVo> queryById(@PathVariable long id) {
        try {
            Department department = departmentDomain.findById(id);
            DepartmentVo departmentVo = new DepartmentVo();
            CopyUtil.copyProperties(department, departmentVo);
            return ResponseVO.<DepartmentVo>success().setData(departmentVo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.<DepartmentVo>exception();
        }
    }

    @PostMapping("add")
    @ResponseBody
    public ResponseVO<Object> add(@Validated DepartmentVo departmentVo, BindingResult error) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }

    @PostMapping("edit")
    @ResponseBody
    public ResponseVO<Object> edit(@Validated DepartmentVo departmentVo, BindingResult error) {
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }

    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseVO<Object> delete(@PathVariable long id) {
        try {
            int count = departmentDomain.deleteById(id);
            if (count== 1) {
                return ResponseVO.success().setMsg("删除成功");
            }
            return ResponseVO.error().setMsg("删除失败！");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
}
