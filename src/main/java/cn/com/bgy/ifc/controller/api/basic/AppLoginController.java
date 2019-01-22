package cn.com.bgy.ifc.controller.api.basic;

import cn.com.bgy.ifc.bgy.annotation.SystemLogAfterSave;
import cn.com.bgy.ifc.bgy.constant.LoginState;
import cn.com.bgy.ifc.bgy.constant.SystemLogType;
import cn.com.bgy.ifc.domain.interfaces.system.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemMenuDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRolePowerDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemUserRoleDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import cn.com.bgy.ifc.service.interfaces.inner.system.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/system")
public class AppLoginController {

    private static Logger logger= LoggerFactory.getLogger(AppLoginController.class);

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

    /**
     * @description:app自动登陆
     * @param: [response, request, userName, currentIp]
     * @return: cn.com.bgy.ifc.entity.vo.ResponseVO<java.lang.Object>
     * @auther: chenlie
     * @date: 2019/1/22 9:58
     */
    @PostMapping ("/appLogin")
    @SystemLogAfterSave(type = SystemLogType.LOGON_LOG,description = "app登录",login = LoginState.NOT_LOGIN)
    public ResponseVO<Object> login(HttpServletResponse response,HttpServletRequest request,String userName,String currentIp) {

        //获取session中的验证码
            Account user=accountDomain.findAccountByUserName(userName);
            if(user==null){
                return ResponseVO.error().setMsg("用户不存在");
            }
            UsernamePasswordToken token = new UsernamePasswordToken(userName, user.getPassword().toUpperCase(),false,currentIp);
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
    }

}
