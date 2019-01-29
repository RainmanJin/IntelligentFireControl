package cn.com.bgy.ifc.config.interceptor;

import cn.com.bgy.ifc.domain.interfaces.system.AccountDomain;
import cn.com.bgy.ifc.domain.interfaces.system.SystemRoleDomain;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemMenu;
import cn.com.bgy.ifc.entity.po.system.SystemPower;
import cn.com.bgy.ifc.entity.po.system.SystemRole;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemMenuService;
import cn.com.bgy.ifc.service.interfaces.inner.system.SystemPowerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm { //AuthenticatingRealm是抽象类，用于认证

    @Autowired
    private AccountDomain userService;

    @Autowired
    private SystemMenuService sytemsMenuService;

    @Autowired
    private SystemRoleDomain systemRoleDomain;

    /*
     * 真实授权抽象方法，供子类调用
     *
     * 这个是当登陆成功之后会被调用，看当前的登陆角色是有有权限来进行操作
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("doGetAuthorizationInfo方法");
        Account account = (Account) principals.fromRealm(this.getClass().getName()).iterator().next();
        Set<String> permissionSet = new HashSet<>();
        Set<String> roleNameSet = new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SystemRole role : account.getRoleList()) {
            roleNameSet.add(Integer.toString(role.getType()));
        }
        //设置角色
        info.addRoles(roleNameSet);
        return info;
    }

    /*
     * 用于认证登录，认证接口实现方法，该方法的回调一般是通过subject.login(token)方法来实现的
     * AuthenticationToken 用于收集用户提交的身份（如用户名）及凭据（如密码）：
     * AuthenticationInfo是包含了用户根据username返回的数据信息，用于在匹马比较的时候进行相互比较
     *
     * shiro的核心是java servlet规范中的filter，通过配置拦截器，使用拦截器链来拦截请求，如果允许访问，则通过。
     * 通常情况下，系统的登录、退出会配置拦截器。登录的时候，调用subject.login(token),token是用户验证信息，
     * 这个时候会在Realm中doGetAuthenticationInfo方法中进行认证。这个时候会把用户提交的验证信息与数据库中存储的认证信息，将所有的数据拿到，在匹配器中进行比较
     * 这边是我们自己实现的CredentialMatcher类的doCredentialsMatch方法，返回true则一致，false则登陆失败
     * 退出的时候，调用subject.logout()，会清除回话信息
     *
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("将用户，密码填充完UsernamePasswordToken之后，进行subject.login(token)之后");
        //这边是界面的登陆数据，将数据封装成token
        UsernamePasswordToken userPasswordToken = (UsernamePasswordToken) token;
        String username = userPasswordToken.getUsername();
        Account user = userService.findAccountByUserName(username);
        List<SystemRole> roleList = systemRoleDomain.queryListByUserId(user.getId());
        List<SystemMenu> menuList=sytemsMenuService.queryMenuPermissionByRole(user.getRoleId());
        user.setRoleList(roleList);
        //将用户信息直接放入缓存中
        user.setMenuPermission(menuList);
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }

}