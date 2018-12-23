package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.utils.ImageGenerationUtil;
import cn.com.bgy.ifc.domain.interfaces.system.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemMenuDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRolePowerDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemUserRoleDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.system.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
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

    @Autowired
    SystemUserRoleDomain systemUserRoleDomain;
    @Autowired
    SystemRolePowerDomain systemRolePowerDomain;


    @GetMapping("/index")
    public String userPage(){

        return "/index";
    }

    /**
     * 根据用户id获取权限菜单
     * @param userId
     * @return
     */
    @GetMapping("/findMenuByUser")
    @ResponseBody
    public ResponseVO findMenuByUser(Long userId){
        Map<String, Object> menuList = systemMenuDomain.findTree(userId);

     return ResponseVO.success().setData(menuList);
    }


    @GetMapping("/getImage")
    public void getImage(HttpServletRequest request,HttpServletResponse response,HttpSession session, OutputStream out ) throws IOException {
        Map<String, Object> map = ImageGenerationUtil.generateCodeAndPic();
        //验证数字
        session.setAttribute("code",map.get("code"));
        response.setHeader("Authorization",map.get("code").toString());

        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg",out);
    }

    /**
     * 登录
     * @param request
     * @param userName
     * @param password
     * @param identifyCode
     * @return
     */
    @PostMapping ("/login")
    @ResponseBody
    public ResponseVO<Object> login(HttpServletResponse response,HttpServletRequest request,String userName,String password,String identifyCode) {
        //验证用户验证码是否一致
        //获取session中的验证码
        String code = request.getSession().getAttribute("code") == null ? "" : request.getSession().getAttribute("code").toString().toLowerCase();
        /*if (identifyCode == null || "".equals(identifyCode)) {
            //验证吗不能为空
            return ResponseVO.error().setMsg("验证吗不能为空");
        } else if (identifyCode.toLowerCase().equals(code)) {*/
            String tokenstr = WebUtils.toHttp(request).getHeader("Authorization");
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password.toUpperCase(),false,request.getRemoteHost());
            try {
                Subject subject = SecurityUtils.getSubject();
                subject.login(token);
                Account account = (Account) subject.getPreviousPrincipals();
                ResponseVO responseVO = new ResponseVO();
                String sessionId= (String) subject.getSession().getId();
                subject.getSession().setAttribute("user",account);
                request.getSession().setAttribute("user", account);
                responseVO= ResponseVO.success().setMsg("success");
                responseVO.setData(sessionId);
                response.setHeader("Authorization",sessionId);
                return responseVO;

            } catch (Exception e) {
                return ResponseVO.error().setMsg("用户名或密码错误");
            }
        /*} else {
            //验证码已失效
            return ResponseVO.error().setMsg("验证码已失效");
        }*/
    }
    @RequiresUser
    @RequiresPermissions("")
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();//取出当前验证主体
        if (subject != null) {
            subject.logout();//不为空，执行一次logout的操作，将session全部清空
        }
        return "login";
    }

}
