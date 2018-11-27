package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.CopyUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.UserDomain;
import cn.com.bgy.ifc.entity.bo.basic.UserBo;
import cn.com.bgy.ifc.entity.po.basic.User;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/basic/user")
public class UserController {

    @Autowired
    private UserDomain userDomain;
    @GetMapping("/userPage")
    public String userPage(){

        return "/basic/userPage";
    }
    @PostMapping("add")
    @ResponseBody
    public   ResponseVO<Object>  add(@Validated UserBo userBO, BindingResult error){
        try {
            //todo userVO 做参数校检
            if(error.hasErrors()){
                return ResponseVO.error().setMsg(error.getFieldError().getDefaultMessage());
            }
            User user= new User();
            CopyUtil.copyProperties(userBO,user);
            userDomain.save(user);
            return ResponseVO.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseVO.exception();
        }
    }
}
