package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.system.SystemOrganizationDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRoleDomain;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
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
    @Autowired
    private SystemOrganizationDomain systemOrganizationDomain;
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

    /**
     * YanXiaoLu
     * 根据当前登录用户添加系统角色
     * @param systemRoleVo
     * @param error
     * @return
     */
    @PostMapping("add")
    @SystemLogAfterSave(type = 1,description = "系统角色添加")
    @ResponseBody
    public ResponseVO<Object> add(@Validated SystemRoleVo systemRoleVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        if(systemRoleVo.getUserId()==null){
            return ResponseVO.error().setMsg("userId参数异常");
        }
        //根据当前登录用户的id获取机构
        SystemOrganization systemOrganization=systemOrganizationDomain.querySystemOrganizationByUserId(systemRoleVo.getUserId());
        if (systemOrganization==null){
            return ResponseVO.error().setMsg("当前登录用户没有所属机构");
        }
        SystemRole systemRole = new SystemRole();
        CopyUtil.copyProperties(systemRoleVo, systemRole);
        systemRole.setOrganizationId(systemOrganization.getId());
        systemRole.setState(1);
        systemRole.setLogicRemove(false);
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
        List<SelectVo> list=SystemConstant.SystemRoleType.getSelectList();
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
    /**
     * @author: YanXiaoLu
     * @description:根据登录用户查询角色类型（下拉框展示）
     * @param:
     * @return:
     */
    @GetMapping("findParentNameByUserId")
    @ResponseBody
    public ResponseVO<List<SystemRole>> findParentNameByUserId(Long userId) {
        SystemRoleVo systemRoleVo = new SystemRoleVo();
        systemRoleVo.setState(SystemConstant.EnableState.ENABLE.getValue());
        List<SystemRole> list = roleDomain.queryListByUserId(userId);
        return ResponseVO.<List<SystemRole>>success().setData(list);
    }
}
