package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemMenuDomain;
import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.AccountVo;
import cn.com.bgy.ifc.service.interfaces.inner.basic.LoginService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/sys/")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    SystemMenuDomain systemMenuDomain;

    @Autowired
    AccountDomain accountDomain;

    @GetMapping("/index")
    public String userPage(){

        return "/index";
    }
    @GetMapping("/findMenuByUser")
    public List<SystemMenu> findMenuByUser(Long userId){
        List menuList=systemMenuDomain.findMenuByUser(userId);
     return menuList;
    }
    @GetMapping("/login")
    @ResponseBody
    public  ResponseVO<Object> login(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //根据用户名验证该用户是否存在
       Account account =  accountDomain.findAccountByUserName(userName,password);
       if (account !=null){
           account.setPassword("");
           account.setPassword("");
           ResponseVO responseVO = new ResponseVO();
           responseVO.setMsg("success");
           responseVO.setData(account);
           return responseVO;
       }
       return ResponseVO.error().setMsg("用户名或密码错误");

    }

}
