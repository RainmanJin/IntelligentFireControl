package cn.com.bgy.ifc.controller.inner.basic;

import cn.com.bgy.ifc.bgy.utils.ImageGenerationUtil;
import cn.com.bgy.ifc.domain.interfaces.basic.SystemMenuDomain;
import cn.com.bgy.ifc.entity.po.basic.SystemMenu;
import cn.com.bgy.ifc.service.interfaces.inner.basic.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @GetMapping("/index")
    public String userPage(){

        return "/index";
    }
    @GetMapping("/findMenuByUser")
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


}
