package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemUserRoleDomain;
import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.SystemUserRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.SystemUserRoleVo;
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

@Controller
@RequestMapping("/basic/systemUserRole")
public class SystemUserRoleController {

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
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
    @GetMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<Account> page,@Validated SystemUserRoleVo systemUserRoleVo, BindingResult error){
        SystemUserRole systemUserRole= new SystemUserRole();
        CopyUtil.copyProperties(systemUserRoleVo,systemUserRole);
        PageInfo<SystemUserRole> pageInfo=systemUserRoleDomain.searchByPage(page,systemUserRole);
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
