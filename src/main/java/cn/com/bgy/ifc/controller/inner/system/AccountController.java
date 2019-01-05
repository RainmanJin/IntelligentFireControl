package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.SystemConstant;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.bgy.utils.ListUtil;
import cn.com.bgy.ifc.bgy.utils.SignatureUtil;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Signature;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/system/account")
public class AccountController extends BaseController {

    private static Logger logger= LoggerFactory.getLogger(AccountController.class);
    @Autowired
    private AccountDomain accountDomain;

    @PostMapping("add")
    @ResponseBody
    public   ResponseVO<Object>  add(Page<Account> page,@Validated AccountVo accountVo, BindingResult error){
            Account account= new Account();
            account.setOrganizationId(this.getUser().getOrganizationId());
            CopyUtil.copyProperties(accountVo,account);
            account.setPassword(SignatureUtil.getBgyMd5(SystemConstant.INITAL_PASSWORD));
            account.setRegistTime(new Date());
            account.setIsDisable(SystemConstant.EnableState.ENABLE.getValue());
            accountDomain.save(account);
            return ResponseVO.success();

    }
    @GetMapping("searchPage")
    @ResponseBody
    public ResponseVO<Object> searchPage(Page<Account> page, Account account){ Account user = this.getUser();
        PageInfo<Account> pageInfo=accountDomain.searchByPage(page,account);

        return ResponseVO.success().setData(pageInfo);
    }


    @GetMapping("findById")
    @ResponseBody
    public ResponseVO<Object> findById(Long id){
          Account user=accountDomain.findById(id);
        return ResponseVO.success().setData(user);
    }
    /**
     * 根据用户id更新用户状态
     * @param ids
     * @return
     */
    @PostMapping("updateIsDisable")
    @SystemLogAfterSave(description = "更新用户状态")
   // @RequiresRoles(value = {SystemConstant.SYSTEM_ROLES_ADMIN,SystemConstant.SYSTEM_ROLES_ORG_ADMIN,SystemConstant.SYSTEM_ROLES_AREA_ADMIN,SystemConstant.SYSTEM_ROLES_PROJECT_ADMIN},logical = Logical.OR)
    @ResponseBody
    public ResponseVO<Object> updateIsDisable(String ids,Integer isDisable ){
          List<Long>idslist=  ListUtil.getListId(ids);
          int res=accountDomain.updateIsDisable(idslist,isDisable);
          if(res>0){
              return ResponseVO.success().setMsg("操作成功！");
          }else{
              return ResponseVO.error().setMsg("操作失败");
          }
    }
    /**
     * 根据用户id更新用户状态
     * @param account
     * @return
     */
    @PostMapping("initalingPassword")
    @SystemLogAfterSave(description = "初始用户密码")
     //@RequiresRoles(value = {SystemConstant.SYSTEM_ROLES_ADMIN,SystemConstant.SYSTEM_ROLES_ORG_ADMIN,SystemConstant.SYSTEM_ROLES_AREA_ADMIN,SystemConstant.SYSTEM_ROLES_PROJECT_ADMIN},logical = Logical.OR)
    @ResponseBody
    public ResponseVO<Object> initalingPassword(Account account ){
        account.setPassword(SignatureUtil.getBgyMd5(SystemConstant.INITAL_PASSWORD));
        int res=accountDomain.initalingPassword(account);
        if(res>0){
            return ResponseVO.success().setMsg("更新成功！");
        }else{
            return ResponseVO.error().setMsg("更新失败");
        }
    }
    /**
     * 查询用户权限
     * @param page
     * @param account
     * @return
     */
    @PostMapping("findUserPowerByPage")
    @ResponseBody
    public ResponseVO<Object> findUserPowerByPage(Page<Account> page,Account account){

        PageInfo<Account> pageInfo= accountDomain.findUserPowerByPage(page, account);
        return ResponseVO.success().setData(pageInfo);
    }
    @PostMapping("editData")
    @ResponseBody
    public   ResponseVO<Object>  editData(@Validated AccountVo accountVo, BindingResult error){
        Account account= accountDomain.findById(accountVo.getId());
        account.setDepartmentId(accountVo.getDepartmentId());
        account.setTelephone(accountVo.getTelephone());
        account.setUserName(accountVo.getUserName());
        account.setUserName(accountVo.getUserName());
        accountDomain.update(account);
        return ResponseVO.success();

    }
}
