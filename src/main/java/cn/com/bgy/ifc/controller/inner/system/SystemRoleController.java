package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.domain.interfaces.system.SystemOrganizationDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRoleDomain;
import cn.com.bgy.ifc.entity.po.system.SystemOrganization;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
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
@Controller
@RequestMapping("/basic/role")
public class SystemRoleController {

    @Autowired
    private SystemRoleService systemRoleService;

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

    @GetMapping("queryById")
    @ResponseBody
    public ResponseVO<SystemRoleVo> queryById(Long id,String token) {
        SystemRole systemRole = systemRoleService.findById(id);
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
    public ResponseVO<Object> add(@Validated SystemRoleVo systemRoleVo, BindingResult error,String token) {
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
        //启用（有效）
        systemRole.setState(SystemConstant.StatusType.EFFECTIVE.getValue());
        int count = systemRoleService.insertSelective(systemRole);
        if (count == 1) {
            return ResponseVO.addSuccess();
        }
        return ResponseVO.editError();
    }

    /**
     * @author: ZhangCheng
     * @description:系统角色修改
     * @param: [systemRoleVo, error, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("edit")
    @SystemLogAfterSave(type = 1,description = "系统角色修改")
    @ResponseBody
    public ResponseVO<Object> edit(@Validated SystemRoleVo systemRoleVo, BindingResult error,String token) {
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
     * @description:系统角色删除
     * @param: [ids, token]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @PostMapping("deleteBatch")
    @SystemLogAfterSave(type = 1,description = "系统角色删除")
    @ResponseBody
    public ResponseVO<Object> deleteBatch(String ids,String token){
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
    @ResponseBody
    public ResponseVO<Object> queryRoleType(String token){
        List<SelectVo> list=SystemConstant.SystemRoleType.getSelectList();
        return  ResponseVO.success().setData(list);
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
