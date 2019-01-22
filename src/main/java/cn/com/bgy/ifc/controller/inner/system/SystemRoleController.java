package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.EnumUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRoleDomain;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.common.SelectVo;
import cn.com.bgy.ifc.entity.vo.system.SystemRoleVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemRoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:系统角色管理
 * @date: 2018-12-05 10:04
 **/
@RestController
@RequestMapping("/basic/role")
public class SystemRoleController  {

    @Autowired
    private SystemRoleService systemRoleService;

    @Autowired
    private SystemRoleDomain systemRoleDomain;
    /**
     * 分页查询
     *
     * @param page
     * @param systemRoleVo
     * @param
     * @return
     */
    @GetMapping("queryPageData")
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
    @PostMapping("editData")
    @SystemLogAfterSave(description = "系统角色修改")
    public ResponseVO<Object> editData(@Validated SystemRoleVo systemRoleVo, BindingResult error) {
        //参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        SystemRole systemRole = new SystemRole();
        CopyUtil.copyProperties(systemRoleVo, systemRole);
        int count = systemRoleService.updateSelective(systemRole);
        if (count == 1) {
            return ResponseVO.editSuccess();
        } else {
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
    @SystemLogAfterSave(description = "系统角色启用操作")
    public ResponseVO<Object> forbidden(SystemRoleVo systemRoleVo) {
        SystemRole systemRole = new SystemRole();
        CopyUtil.copyProperties(systemRoleVo, systemRole);
        int count = systemRoleService.updateSelective(systemRole);
        if (count == 1) {
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
    @PostMapping("deleteData")
    @SystemLogAfterSave(description = "系统角色删除")
    public ResponseVO<Object> deleteData(String ids) {
        List<Long> list = ListUtil.getListId(ids);
        int deleteCount = systemRoleService.deleteBatch(list);
        if (deleteCount == list.size()) {
            return ResponseVO.deleteSuccess();
        } else {
            return ResponseVO.deleteError();
        }
    }

    /**
     * @Author huxin
     * @Description 获取角色类型
     * @Date 2018/12/15 17:39
     */
    @GetMapping("queryRoleType")
    public ResponseVO<Object> queryRoleType() {
        List<SelectVo> list = EnumUtil.getSelectList(SystemConstant.SystemRoles.class);
        return ResponseVO.success().setData(list);
    }

    /**
     * @author: chenlie
     * @description:根据登录用户查询角色
     * @param:
     * @return:
     */
    @GetMapping("queryListByUserId")
    public ResponseVO<Object> findParentNameByUserId(Long userId) {
        List<SystemRole> list = systemRoleDomain.queryListByUserId(userId);
        return ResponseVO.<Object>success().setData(list);
    }
    /**
     * @author: chenlie
     * @description:查询系统所有角色
     * @param:
     * @return:
     */
    @GetMapping("queryAll")
    public ResponseVO<Object> queryAll() {

        try {

        List<SystemRole> list = systemRoleDomain.queryAllList(null);
        List<Map<String,Object>> resultList=new ArrayList<>();

        Map<String,Object> map1=new HashMap<>();
        Map<String,Object> map2=new HashMap<>();
        Map<String,Object> map3=new HashMap<>();
        Map<String,Object> map4=new HashMap<>();
        List<SystemRole> list1=new ArrayList<>();
        List<SystemRole> list2=new ArrayList<>();
        List<SystemRole> list3=new ArrayList<>();
        List<SystemRole> list4=new ArrayList<>();
        for (SystemRole role:list){
            if (role.getType() !=null&&role.getType().longValue()==1){
                list1.add(role);
            }
            if (role.getType() !=null&&role.getType().longValue()==2){
                list2.add(role);
            }
            if (role.getType() !=null&&role.getType().longValue()==3){
                list3.add(role);
            }
            if (role.getType() !=null&&role.getType().longValue()==4){
                list4.add(role);
            }
        }
        map1.put("type","platform");
        map1.put("list",list1);
        map1.put("name","平台级用户");
        map2.put("list",list2);
        map2.put("type","head");
        map2.put("name","集团级用户");
        map3.put("list",list3);
        map3.put("type","area");
        map3.put("name","区域级用户");
        map4.put("list",list4);
        map4.put("type","project");
        map4.put("name","项目级用户");
        resultList.add(map1);
        resultList.add(map2);
        resultList.add(map3);
        resultList.add(map4);
            return ResponseVO.<Object>success().setData(resultList);
      }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
