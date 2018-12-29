package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.domain.interfaces.system.SystemOrganizationDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRoleDomain;
import cn.com.bgy.ifc.entity.po.system.Department;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.system.DepartmentVo;
import cn.com.bgy.ifc.entity.vo.system.SystemRoleVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemRoleService;
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
@RestController
@RequestMapping("/basic/role")
public class SystemRoleController {

    @Autowired
    private SystemRoleService systemRoleService;
    /**
     * 分页查询
     * @param page
     * @param systemRoleVo
     * @param
     * @return
     */
    @GetMapping("queryPage")
    public ResponseVO<PageInfo<SystemRole>> queryList(Page<SystemRole> page, SystemRoleVo systemRoleVo) {
            PageInfo<SystemRole> pageInfo = systemRoleService.queryListByPage(page, systemRoleVo);
            return ResponseVO.<PageInfo<SystemRole>>success().setData(pageInfo);
    }

    /**
     * @author: ZhangCheng
     * @description:ID查询
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<cn.com.bgy.ifc.entity.vo.system.SystemRoleVo>
     */
    @GetMapping("findById")
    public ResponseVO<SystemRoleVo> findById(Long id) {
        SystemRole systemRole = systemRoleService.findById(id);
        SystemRoleVo systemRoleVo = new SystemRoleVo();
        CopyUtil.copyProperties(systemRole, systemRoleVo);
        return ResponseVO.<SystemRoleVo>success().setData(systemRoleVo);
    }

    /**
     * @author: ZhangCheng
     * @description:系统角色修改
     * @param: [systemRoleVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("edit")
    @SystemLogAfterSave(type = 1,description = "系统角色修改")
    public ResponseVO<Object> edit(@Validated SystemRoleVo systemRoleVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemRole systemRole = new SystemRole();
        CopyUtil.copyProperties(systemRoleVo, systemRole);
        int count =  systemRoleService.updateSelective(systemRole);
        if (count == 1) {
            return ResponseVO.editSuccess();
        }else{
            return ResponseVO.editError();
        }
    }

    /**
     * @author: ZhangCheng
     * @description:系统角色启用操作
     * @param: [systemRoleVo]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("forbidden")
    @SystemLogAfterSave(type = 1,description = "系统角色启用操作")
    public ResponseVO<Object> forbidden(SystemRoleVo systemRoleVo) {
        SystemRole systemRole = new SystemRole();
        CopyUtil.copyProperties(systemRoleVo, systemRole);
        int count = systemRoleService.updateSelective(systemRole);
        if (count ==1) {
            return ResponseVO.success().setMsg("操作成功");
        }
        return ResponseVO.error().setMsg("操作失败！");
    }



    /**
     * @author: ZhangCheng
     * @description:系统角色删除
     * @param: [ids]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteBatch")
    @SystemLogAfterSave(type = 1,description = "系统角色删除")
    public ResponseVO<Object> deleteBatch(String ids){
        List<Long> list= ListUtil.getListId(ids);
       int deleteCount=systemRoleService.deleteBatch(list);
       if(deleteCount==list.size()){
           return ResponseVO.deleteSuccess();
       }else{
           return ResponseVO.deleteError();
       }
    }

    /**
     * @Author huxin
     * @Description 获取角色类型
     * @Date 2018/12/15 17:39
     */
    @GetMapping("/queryRoleType")
    public ResponseVO<Object> queryRoleType(){
        List<SelectVo> list=SystemConstant.SystemRoles.getSelectList();
        return  ResponseVO.success().setData(list);
    }

    /**
     * @author: YanXiaoLu
     * @description:根据登录用户查询角色类型（下拉框展示）
     * @param:
     * @return:
     */
   // @GetMapping("findParentNameByUserId")
    /*public ResponseVO<List<SystemRole>> findParentNameByUserId(Long userId) {
        SystemRoleVo systemRoleVo = new SystemRoleVo();
        systemRoleVo.setState(SystemConstant.EnableState.ENABLE.getValue());
        List<SystemRole> list = roleDomain.queryListByUserId(userId);
        return ResponseVO.<List<SystemRole>>success().setData(list);
    }*/
}
