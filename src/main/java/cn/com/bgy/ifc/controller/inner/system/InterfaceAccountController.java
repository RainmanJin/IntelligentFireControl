package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.utils.CopyUtil;

import cn.com.bgy.ifc.controller.inner.common.BaseController;
import cn.com.bgy.ifc.domain.interfaces.system.InterfaceAccountDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.system.InterfaceAccountVo;
import cn.com.bgy.ifc.entity.po.system.InterfaceAccount;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: YanXiaoLu
 * @description:接口用户
 * @date: 2018-12-05 09:30
 **/
@RestController
@RequestMapping("/system/interfaceAccount")
public class InterfaceAccountController extends BaseController {
    @Autowired
    private InterfaceAccountDomain interfaceAccountDomain;

    @PostMapping("add")
    @SystemLogAfterSave(description = "添加接口用户")
    public ResponseVO<Object> add(@Validated InterfaceAccountVo interfaceaccountVo, BindingResult error) {
        // 做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        InterfaceAccount interfaceaccount = new InterfaceAccount();
        CopyUtil.copyProperties(interfaceaccountVo, interfaceaccount);
        Account user=this.getUser();
        interfaceaccount.setOrgId(user.getOrganizationId());
        interfaceaccount.setCreateTime(new Date());
        interfaceaccount.setLogicRemove(false);
        interfaceaccount.setState(2L);
        interfaceAccountDomain.insert(interfaceaccount);
        return ResponseVO.success();

    }

    @SystemLogAfterSave(description = "修改接口用户")
    @PostMapping("update")
    public ResponseVO<Object> update(@Validated InterfaceAccountVo interfaceaccountVo, BindingResult error) {

        // 做参数校检
        if (error.hasErrors()) {
            return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
        }
        InterfaceAccount interfaceaccount = new InterfaceAccount();
        CopyUtil.copyProperties(interfaceaccountVo, interfaceaccount);

        interfaceAccountDomain.update(interfaceaccount);
        return ResponseVO.success();

    }

    @DeleteMapping("delete/{id}")
    public ResponseVO<Object> delete(@PathVariable Long id) {
        if (id == null) {
            return ResponseVO.error().setMsg("id不能为空");
        }
        interfaceAccountDomain.deleteById(id);
        return ResponseVO.success();
    }

    @GetMapping("findById")
    public ResponseVO<Object> findById(Long id) {
        if (id == null) {
            return ResponseVO.error().setMsg("id不能为空");
        }
        InterfaceAccount interfaceaccount = interfaceAccountDomain.findById(id);
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(interfaceaccount);
        responseVO.setCode(ResponseVO.SUCCESS);
        responseVO.setMsg("success");
        return responseVO.setData(interfaceaccount);
    }

    /**
     * @param page
     * @return
     * @author chenlie
     * 分页查询
     */
    @GetMapping("searchPage")
    public ResponseVO<Object> searchPage(Page<InterfaceAccount> page, InterfaceAccount interfaceAccount) {
        PageInfo<InterfaceAccount> pageInfo = interfaceAccountDomain.searchByWhere(page, interfaceAccount);
        return ResponseVO.success().setData(pageInfo);
    }

    /**
     * 批量删除用户接口
     *
     * @param ids
     * @return
     */
    @PostMapping("deleteInterfaceAccount")
    @SystemLogAfterSave(description = "批量删除接口用户")
    public ResponseVO<Object> deleteInterfaceAccount(String ids) {
        if (ids == null || ids.isEmpty()) {
            return ResponseVO.error().setMsg("参数异常");
        }
        List<Long> list = JSONArray.parseArray(ids, Long.class);
        interfaceAccountDomain.deleteInterfaceAccount(list);
        return ResponseVO.success().setMsg("删除成功");
    }

}