package cn.com.bgy.ifc.config.interceptor;

import cn.com.bgy.ifc.bgy.annotation.RolePermission;
import cn.com.bgy.ifc.bgy.utils.StringUtil;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.po.system.SystemPower;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BasePathInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String []  allowDomain= {"http://192.168.0.200:8080","http://192.168.0.104:8080","http://47.99.100.79:8080","http://127.0.0.1:8080","http://www.tgiant.cn:8080","http://www.tgiant.com:8080"};
        Set<String> allowedOrigins= new HashSet<>(Arrays.asList(allowDomain));
        String originHeader=request.getHeader("Origin");
        if (allowedOrigins.contains(originHeader)) {
            response.setHeader("Access-Control-Allow-Origin", originHeader);
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,PATCH,PUT,OPTIONS,DELETE,HEAD");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "content-type, x-requested-with");
            response.setHeader("Access-Control-Allow-Credentials", "true");
        }
        Account sysUser = (Account) request.getSession().getAttribute("user");
        if (null == sysUser && !StringUtil.contains(request.getRequestURI(),"/login")&&!StringUtil.contains(request.getRequestURI(),"/appLogin") && !StringUtil.contains(request.getRequestURI(),"/getImage")&&!StringUtil.contains(request.getRequestURI(),"/external/interface")) {
              //如果是ajax返回指定数据
               response.setCharacterEncoding("UTF-8");
               response.setContentType("application/json");
               response.getWriter().write(JSON.toJSONString(ResponseVO.withoutLogin()));
               return false;
        }
        //判断请求url是否有 权限注解  有则代表需要做权限校验 无则直接放行
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //获取controller上的权限注解
        RolePermission rolePermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RolePermission.class);
        //RolePermission rolePermission = handlerMethod.getMethodAnnotation(RolePermission.class);
        if (rolePermission == null) {
            return true;
        }else{
            //判断权限拦截
            boolean hasPermission = false;
        /*for (SystemPower power : sysUser.getPowerList()) {
            if (power.getName().length()==0) {
                continue;
            }
            if (StringUtil.contains(request.getRequestURI(),power.getName())){
                hasPermission = true;
                break;
            }
        }*/

            if (StringUtil.contains(request.getRequestURI(),"systemLog")){
                System.out.println("======="+request.getRequestURI());
                hasPermission = true;
                //break;
            }
            if (!hasPermission){
                //如果是ajax返回指定数据
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().write(JSON.toJSONString(ResponseVO.withoutPermission()));
                return false;
            }
        }
        return true;
    }
}
