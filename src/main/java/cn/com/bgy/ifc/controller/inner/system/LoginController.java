package cn.com.bgy.ifc.controller.inner.system;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.bgy.utils.ImageGenerationUtil;
import cn.com.bgy.ifc.domain.interfaces.system.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemUserRoleDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.system.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

@RestController
@RequestMapping("/system/")
public class LoginController {

    private static Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @Autowired
    AccountDomain accountDomain;

    @Autowired
    SystemUserRoleDomain systemUserRoleDomain;


    @GetMapping("/index")
    public String userPage(){
        return "/index";
    }

    /**
     * @description:
     * @param: [request, response, session]
     * @return: \
     * @auther: chenlie
     * @date: 2019/1/22 9:42
     */
    @GetMapping("/getImage")
    public String getImage(HttpServletRequest request,HttpServletResponse response,HttpSession session ) throws IOException {

        Map<String, Object> map = ImageGenerationUtil.generateCodeAndPic();
        //验证数字
        session.setAttribute("identifyCode",map.get("code"));
       // response.setHeader("Authorization",session.getId());
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        ImageIO.write((RenderedImage) map.get("codePic"), "png",out);
        byte[] imageBase64=Base64.getEncoder().encode(out.toByteArray());
        return "data:image/png;base64,"+new String(imageBase64);
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
    @SystemLogAfterSave(type = SystemLogType.LOGON_LOG,description = "系统登录",login = LoginState.NOT_LOGIN)
    public ResponseVO<Object> login(HttpServletResponse response,HttpServletRequest request,String userName,String password,String identifyCode,String currentIp) {
        //获取session中的验证码
     /*   String code = request.getSession().getAttribute("identifyCode") == null ? "" : request.getSession().getAttribute("identifyCode").toString().toLowerCase();
        if (identifyCode == null || "".equals(identifyCode)) {
            //验证码不能为空
            return ResponseVO.error().setMsg("验证码不能为空");
        } else if (identifyCode.toLowerCase().equals(code)) {*/
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password.toUpperCase(),false,currentIp);
            try {
                Subject subject = SecurityUtils.getSubject();
                subject.login(token);
                Account account = (Account) subject.getPrincipal();
                subject.getSession().setAttribute("user",account);
                request.getSession().setAttribute("user", account);
                //记录登陆ip
                account.setCurrentIp(currentIp);
                account.setLastIp(currentIp);
                accountDomain.updateSelective(account);
                return ResponseVO.success().setData(account).setMsg("登陆成功");

            } catch (Exception e) {
                logger.error(e.getMessage());
                return ResponseVO.error().setMsg("用户名或密码错误");
            }
       /* } else {
            return ResponseVO.error().setMsg("验证码错误");
        }*/
    }
    /**
     * @description:登出
     * @param: []
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO
     * @auther: chenlie
     * @date: 2019/1/22 9:42
     */
    @RequiresUser
    @RequestMapping("/logout")
    @ResponseBody
    public ResponseVO logout() {
        Subject subject = SecurityUtils.getSubject();//取出当前验证主体
        if (subject != null) {
            subject.logout();//不为空，执行一次logout的操作，将session全部清空
        }
        return ResponseVO.success().setMsg("退出成功");
    }

}
