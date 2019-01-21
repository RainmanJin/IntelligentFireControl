package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.system.SystemUserRoleDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemUserRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.SystemUserRoleVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/system/systemUserRole")
public class SystemUserRoleController extends BaseController {

    @Autowired
    private SystemUserRoleDomain systemUserRoleDomain;
    @GetMapping("/systemUserRolePage")
    public String userPage(){

        return "/basic/systemUserRolePage";
    }
    @PostMapping("add")
    @ResponseBody
    public   ResponseVO<Object>  add(Page<SystemUserRole> page, @Validated SystemUserRoleVo systemUserRoleVo, BindingResult error){

        try {
            //todo userVO 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            SystemUserRole systemUserRole= new SystemUserRole();
            CopyUtil.copyProperties(systemUserRoleVo,systemUserRole);
            systemUserRoleDomain.save(systemUserRole);
            return ResponseVO.addSuccess().setMsg("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }

    /**
     * 用户角色分页查询
     * @author chenlie
     * @param page
     * @param account
     * @return
     */
    @GetMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<Account> page, Account account){
        Account user=this.getUser();
        account.setOrganizationId(user.getOrganizationId());
        PageInfo<Map<String,Object>> pageInfo=systemUserRoleDomain.searchByPage(page,account);
        return ResponseVO.success().setData(pageInfo);
    }

    @PostMapping("deleteById")
    @ResponseBody
    public ResponseVO<Object> deleteById(Long id){

        SystemUserRole systemUserRole=systemUserRoleDomain.findById(id);
            if(systemUserRole==null) {
                ResponseVO.error().setMsg("请求数据不存在，请刷新重试！");
            }
          int res=systemUserRoleDomain.deleteById(id);
        return ResponseVO.success().setMsg("数据删除成功！");
    }


}
