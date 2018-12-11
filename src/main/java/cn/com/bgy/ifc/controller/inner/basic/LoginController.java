package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.domain.interfaces.basic.AccountDomain;
import cn.com.bgy.ifc.bgy.utils.ImageGenerationUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemMenuDomain;
import cn.com.bgy.ifc.entity.po.basic.Account;
import cn.com.bgy.ifc.entity.po.basic.SystemMenu;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.basic.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

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


    @GetMapping("/getImage")
    public void getImage( HttpSession session, OutputStream out ) throws IOException {
        Map<String, Object> map = ImageGenerationUtil.generateCodeAndPic();
        //验证数字
        session.setAttribute("code",map.get("code"));
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg",out);
    }
    @GetMapping("/login")
    @ResponseBody
    public ResponseVO<Object> login(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //根据用户名验证该用户是否存在
        Account account = accountDomain.findAccountByUserName(userName, password);
        if (account != null) {
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
