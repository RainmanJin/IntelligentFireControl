package cn.com.bgy.ifc.config.interceptor;

import cn.com.bgy.ifc.bgy.utils.StringUtil;
import cn.com.bgy.ifc.entity.po.system.Account;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.util.PermissionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BasePathInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String []  allowDomain= {"http://192.168.0.112:8080","http://192.168.0.109:8080","http://192.168.0.108:8080","http://127.0.0.1:8080"};
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
        if (null == sysUser && !StringUtil.contains(request.getRequestURI(),"/login") && !StringUtil.contains(request.getRequestURI(),"/getImage")) {
            String requestedWith = request.getHeader("X-Requested-With");
            if (StringUtil.isNotEmpty(requestedWith) &&  "XMLHttpRequest".equals("requestedWith")) {
                //如果是ajax返回指定数据
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json");
                response.getWriter().write(JSON.toJSONString(ResponseVO.withoutLogin()));
                return false;
            } else {//不是ajax进行重定向处理
                response.sendRedirect("/system/login");
                return false;
            }
        }
        return true;
    }
}
