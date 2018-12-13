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
import org.springframework.web.bind.annotation.PostMapping;
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

    /**
     * 根据用户id获取权限菜单
     * @param userId
     * @return
     */
    @GetMapping("/findMenuByUser")
    @ResponseBody
    public ResponseVO findMenuByUser(Long userId){
        List<SystemMenu> menuList=systemMenuDomain.findMenuByUser(userId);

     return ResponseVO.success().setData(menuList);
    }


    @GetMapping("/getImage")
    public void getImage( HttpSession session, OutputStream out ) throws IOException {
        Map<String, Object> map = ImageGenerationUtil.generateCodeAndPic();
        //验证数字
        session.setAttribute("code",map.get("code"));
        ImageIO.write((RenderedImage) map.get("codePic"), "jpeg",out);
    }

    /**
     * 登录
     * @param request
     * @param telephone
     * @param password
     * @param identifyCode
     * @return
     */
    @PostMapping ("/login")
    @ResponseBody
    public ResponseVO<Object> login(HttpServletRequest request,String telephone,String password,String identifyCode) {
//       String telephone = request.getParameter("telephone");
//       String password = request.getParameter("password");
//       String identifyCode = request.getParameter("identifyCode");
        //验证用户验证码是否一致
        //获取session中的验证码
         String code = request.getSession().getAttribute("code")==null?"": request.getSession().getAttribute("code").toString().toLowerCase();
        if("".equals(identifyCode)||identifyCode==null){
            //验证吗不能为空
            return ResponseVO.error().setMsg("验证吗不能为空");
        }else if(identifyCode.toLowerCase().equals(code)){
            //根据电话号码验证该用户是否存在
            Account account = accountDomain.findAccountByUserName(telephone, password);
            if (account != null) {

                account.setPassword(null);
                ResponseVO responseVO = new ResponseVO();
                responseVO.setMsg("success");
                responseVO.setData(account);
                return responseVO;
            }else {
                return ResponseVO.error().setMsg("用户名或密码错误");
            }
        }else {
            //验证码已失效
            return  ResponseVO.error().setMsg("验证码已失效");
        }
    }


}
