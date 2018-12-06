package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.entity.vo.basic.AccountVo;
import cn.com.bgy.ifc.service.interfaces.inner.basic.LoginService;
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

import java.util.List;

@Controller
@RequestMapping("/sys/")
public class LoginController {

    @Autowired
    LoginService loginService;



    @GetMapping("/index")
    public String userPage(){

        return "/basic/index";
    }

    public List<String> getMenuList(Long userId){


     return null;
    }

}
