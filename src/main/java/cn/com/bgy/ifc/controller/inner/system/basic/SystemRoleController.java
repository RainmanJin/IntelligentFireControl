package cn.com.bgy.ifc.controller.inner.system.basic;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.system.basic.SystemRoleDomain;
import cn.com.bgy.ifc.entity.po.system.basic.SystemRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.SelectVo;
import cn.com.bgy.ifc.entity.vo.system.basic.SystemRoleVo;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ZhangCheng
 * @description:系统角色管理
 * @date: 2018-12-05 10:04
 **/
@Controller
@RequestMapping("/basic/role")
public class SystemRoleController {

    @Autowired
    private SystemRoleDomain roleDomain;

    /**
     * 分页查询
     * @param page
     * @param systemRoleVo
     * @param
     * @return
     */
    @PostMapping("queryList")
    @ResponseBody
    public ResponseVO<PageInfo<SystemRole>> queryList(Page<SystemRole> page, SystemRoleVo systemRoleVo) {
        try {
            PageInfo<SystemRole> pageInfo = roleDomain.queryListByPage(page, systemRoleVo);
            return ResponseVO.<PageInfo<SystemRole>>success().setData(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.<PageInfo<SystemRole>>exception();
        }
    }

    @GetMapping("queryById/{id}")
    @ResponseBody
    public ResponseVO<SystemRoleVo> queryById(@PathVariable long id,String token) {
        SystemRole systemRole = roleDomain.findById(id);
        SystemRoleVo systemRoleVo = new SystemRoleVo();
        CopyUtil.copyProperties(systemRole, systemRoleVo);
        return ResponseVO.<SystemRoleVo>success().setData(systemRoleVo);
    }

    @PostMapping("add")
    @ResponseBody
    public ResponseVO<Object> add(@Validated SystemRoleVo systemRoleVo, BindingResult error,String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemRole systemRole = new SystemRole();
        System.out.println("*****"+systemRoleVo.getName());
        System.out.println("*****"+systemRoleVo.getType());
        CopyUtil.copyProperties(systemRoleVo, systemRole);
        int count = roleDomain.insert(systemRole);
        if (count == 1) {
            return ResponseVO.success().setMsg("添加成功！");
        }
        return ResponseVO.error().setMsg("添加失败！");
    }

    @PostMapping("edit")
    @ResponseBody
    public ResponseVO<Object> edit(@Validated SystemRoleVo systemRoleVo, BindingResult error,String token) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemRole systemRole = new SystemRole();
        CopyUtil.copyProperties(systemRoleVo, systemRole);
        int count = roleDomain.updateRole(systemRole);
        if (count == 1) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }


    @DeleteMapping("delete/{id}")
    @ResponseBody
    public ResponseVO<Object> delete(@PathVariable long id) {
        int count = roleDomain.deleteById(id);
        if (count == 1) {
            return ResponseVO.success().setMsg("删除成功");
        }
        return ResponseVO.error().setMsg("删除失败");
    }
    /**
     * @Author huxin
     * @Description 系统角色修改
     * @Date 2018/12/15 12:21
     */
    @PostMapping("updateRole")
    @ResponseBody
    public ResponseVO<Object> updateRole(SystemRole systemRole, BindingResult error,String token) {
        int count = roleDomain.updateRole(systemRole);
        if (count == 1) {
            return ResponseVO.success().setMsg("修改成功");
        }
        return ResponseVO.error().setMsg("修改失败！");
    }

    /**
     * @Author huxin
     * @Description 获取角色类型
     * @Date 2018/12/15 17:39
     */
    @GetMapping("/queryRoleType")
    @ResponseBody
    public ResponseVO<Object> queryRoleType(String token){
        List<SelectVo> list=SystemConstant.SyetemRoleType.getSelectList();
        return  ResponseVO.success().setData(list);
    }
    /**
     * 批量删除系统角色(通过id删除系统角色)
     * @param longs
     * @return
     */
    @PostMapping("deleteSystemRole")
    @SystemLogAfterSave(type = 1,description = "批量删除机构信息")
    @ResponseBody
    public ResponseVO<Object> deleteSystemRole(String longs) {
        if (longs==null){
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list = JSONArray.parseArray(longs,Long.class);
        Long[] deleteLongs = new Long[list.size()];
        list.toArray(deleteLongs);
        if (list.size()==1){
            roleDomain.deleteById(deleteLongs[0]);
            return ResponseVO.success().setMsg("删除成功");
        }else {
            roleDomain.deleteRole(deleteLongs);
            return ResponseVO.success().setMsg("删除成功");
        }
    }
}
