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
import cn.com.bgy.ifc.service.interfaces.api.system.UserApiService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
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

    @Autowired
    private AccountDomain accountDomain;

    @Autowired
    private UserApiService userApiService;

    /**
     * @description:新增用户
     * @param: [page, accountVo, error]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/22 9:44
     */
    @PostMapping("add")
    public ResponseVO<Object> add(Page<Account> page, @Validated AccountVo accountVo, BindingResult error) {

        Account account = new Account();
        CopyUtil.copyProperties(accountVo, account);
        account.setOrganizationId(this.getUser().getOrganizationId());
        account.setPassword(SignatureUtil.getBgyMd5(SystemConstant.INITAL_PASSWORD));
        account.setRegistTime(new Date());
        account.setIsDisable(SystemConstant.EnableState.ENABLE.getValue());
        accountDomain.save(account);
        return ResponseVO.success();

    }

    /**
     * @description:
     * @param: [page, account]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/22 9:39
     */
    @GetMapping("searchPage")
    public ResponseVO<Object> searchPage(Page<Account> page, Account account) {
        Account user = this.getUser();
        PageInfo<Account> pageInfo = accountDomain.searchByPage(page, account);

        return ResponseVO.success().setData(pageInfo);
    }

    /**
     * @description:通过id获取用户
     * @param: [id]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/22 9:38
     */
    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {

        Account user = accountDomain.findById(id);
        return ResponseVO.success().setData(user);
    }

    /**
     * 根据用户id更新用户状态
     *
     * @param ids
     * @return
     */
    @PostMapping("updateIsDisable")
    @SystemLogAfterSave(description = "更新用户状态")
    public ResponseVO<Object> updateIsDisable(String ids, Integer isDisable) {
        List<Long> idslist = ListUtil.getListId(ids);
        int res = accountDomain.updateIsDisable(idslist, isDisable);
        if (res > 0) {
            return ResponseVO.success().setMsg("操作成功！");
        } else {
            return ResponseVO.error().setMsg("操作失败");
        }
    }

    /**
     * 根据用户id更新用户状态
     *
     * @param account
     * @return
     */
    @PostMapping("initalingPassword")
    @SystemLogAfterSave(description = "初始用户密码")
    public ResponseVO<Object> initalingPassword(Account account) {
        account.setPassword(SignatureUtil.getBgyMd5(SystemConstant.INITAL_PASSWORD));
        int res = accountDomain.initalingPassword(account);
        if (res > 0) {
            return ResponseVO.success().setMsg("更新成功！");
        } else {
            return ResponseVO.error().setMsg("更新失败");
        }
    }

    /**
     * 查询用户权限
     *
     * @param page
     * @param account
     * @return
     */
    @PostMapping("findUserPowerByPage")
    public ResponseVO<Object> findUserPowerByPage(Page<Account> page, Account account) {

        PageInfo<Account> pageInfo = accountDomain.findUserPowerByPage(page, account);
        return ResponseVO.success().setData(pageInfo);
    }

    @PostMapping("editData")
    public ResponseVO<Object> editData(@Validated AccountVo accountVo, BindingResult error) {
        Account account = accountDomain.findById(accountVo.getId());
        if (account == null) {
            return ResponseVO.error().setMsg("未找到用户");
        }
        account.setDepartmentId(accountVo.getDepartmentId());
        account.setTelephone(accountVo.getTelephone());
        account.setUserName(accountVo.getUserName());
        account.setSex(accountVo.getSex());
        account.setRemark(accountVo.getRemark());
        account.setJobNumber(accountVo.getJobNumber());
        account.setIdentityNumber(accountVo.getIdentityNumber());
        accountDomain.updateSelective(account);
        return ResponseVO.success();

    }

    /**
     * 根据用户id更新用户状态
     *
     * @param
     * @return
     */
    @PostMapping("updatePassword")
    @SystemLogAfterSave(description = "初始用户密码")
    public ResponseVO<Object> updatePassword(String oldPassword, String newPassword, Long id) {
        Account account = accountDomain.findById(id);
        if (oldPassword.equals(account.getPassword())) {
            account.setPassword(newPassword);
            int res = accountDomain.initalingPassword(account);
            if (res > 0) {
                return ResponseVO.success().setMsg("更新成功！");
            } else {
                return ResponseVO.error().setMsg("更新失败");
            }
        } else {
            return ResponseVO.error().setMsg("原始密码不正确！");
        }

    }

    /**
     * @author: ZhangCheng
     * @description:同步集成平台用户数据
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     */
    @GetMapping("synchroData")
    public ResponseVO<Object> synchroData() {
        return userApiService.baseObtainBgyUser(1, 1000);
    }
}
