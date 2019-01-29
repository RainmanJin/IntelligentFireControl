package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.system.SystemUserRoleDomain;
import cn.com.bgy.ifc.entity.po.equipment.Analog;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemUserRole;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.system.SystemUserRoleVo;
import cn.com.bgy.ifc.service.interfaces.inner.system.AccountService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/system/systemUserRole")
public class SystemUserRoleController extends BaseController {

    @Autowired
    private SystemUserRoleDomain systemUserRoleDomain;

    @Autowired
    private AccountService accountService;

    /**
     * 用户角色分页查询
     *
     * @param page
     * @param account
     * @return
     * @author chenlie
     */
    @GetMapping("queryPageData")
    public ResponseVO<PageInfo<Account>> queryPage(Page<Analog> page, Account account) {
        PageInfo<Account> pageInfo = accountService.queryListByPage(page, account);
        return ResponseVO.<PageInfo<Account>>success().setData(pageInfo);
    }

    /**
     *  修改用户角色
     * @param account
     * @return
     */
    @PostMapping("editData")
    public ResponseVO<Object> editData(Account account){
        int result=accountService.updateSelective(account);
        if (result == 1) {
            return ResponseVO.editSuccess();
        } else {
            return ResponseVO.editError();
        }
    }

    @PostMapping("deleteById")
    public ResponseVO<Object> deleteById(Long id) {
        SystemUserRole systemUserRole = systemUserRoleDomain.findById(id);
        if (systemUserRole == null) {
            ResponseVO.error().setMsg("请求数据不存在，请刷新重试！");
        }
        systemUserRoleDomain.deleteById(id);
        return ResponseVO.success().setMsg("数据删除成功！");
    }


}
