package cn.com.bgy.ifc.controller.inner.common;

import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.system.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ZhangCheng
 * @description:系统中公共调用部分（省略权限控制拦截）
 * @date: 2019-01-29 16:43
 **/
@RestController
@RequestMapping("/main/basics/")
public class SystemController extends BaseController{

    @Autowired
    private AccountService accountService;

    /**
     * 查询成员信息
     * @param id
     * @return
     */
    @GetMapping("findAccountById")
    public ResponseVO<Object> findById(Long id) {
        Account account = accountService.findById(id);
        return ResponseVO.success().setData(account);
    }
}
