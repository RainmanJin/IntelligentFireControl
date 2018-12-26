package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.system.AccountDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.AccountVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sys/account")
public class AccountController extends BaseController {

    @Autowired
    private AccountDomain accountDomain;
    @GetMapping("/accountPage")
    public String userPage(){

        return "/basic/accountPage";
    }
    @PostMapping("add")
    @ResponseBody
    public   ResponseVO<Object>  add(Page<Account> page,@Validated AccountVo accountVo, BindingResult error){
        try {
            //todo userVO 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            Account account= new Account();
            CopyUtil.copyProperties(accountVo,account);
            accountDomain.save(account);
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
    @GetMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<Account> page, Account account){ Account user = this.getUser();
        //Account account= new Account();
        //CopyUtil.copyProperties(accountVo,account);
        //account.setRegistTimeStart(new Date());
        PageInfo<Account> pageInfo=accountDomain.searchByPage(page,account);

        return ResponseVO.success().setData(pageInfo);
    }

    /**
     * 根据用户id删除用户
     * @param ids
     * @return
     */
    @PostMapping("delete")
    @SystemLogAfterSave(type = 1,description = "删除用户")
   // @RequiresRoles(value = {SystemConstant.SYSTEM_ROLES_ADMIN,SystemConstant.SYSTEM_ROLES_ORG_ADMIN,SystemConstant.SYSTEM_ROLES_AREA_ADMIN,SystemConstant.SYSTEM_ROLES_PROJECT_ADMIN},logical = Logical.OR)
    @ResponseBody
    public ResponseVO<Object> deleteById(String ids){
          List<Long>idslist=  ListUtil.getListId(ids);
          int res=accountDomain.deleteBatch(idslist);
          if(res>0){
              return ResponseVO.success().setMsg("数据删除成功！");
          }else{
              return ResponseVO.error().setMsg("删除失败");
          }
    }

    @PostMapping("findUserPowerByPage")
    @ResponseBody
    public ResponseVO<Object> findUserPowerByPage(Page<Account> page,Account account){

        PageInfo<Account> pageInfo= accountDomain.findUserPowerByPage(page, account);
        return ResponseVO.success().setData(pageInfo);
    }

}
