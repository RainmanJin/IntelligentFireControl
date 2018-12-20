package cn.com.bgy.ifc.bgy.exception;

import cn.com.bgy.ifc.bgy.utils.WebsiteUtil;
import cn.com.bgy.ifc.entity.vo.ResponseVO;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ZhangCheng
 * @description:全局异常处理
 *  用于处理在请求映射和请求处理过程中抛出的异常的类
 * @date: 2018-12-05 16:26
 **/
//@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(GlobalHandlerExceptionResolver.class);

    /**
     * @author: ZhangCheng
     * @description:异常处理方法,为了系统安全,只让用户看自定义异常错误信息
     * @param: [request, response, handler, ex]
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //如果请求是ajax 返回json格式
        if (WebsiteUtil.isAjax(request)) {
            ModelAndView modelAndView = new ModelAndView();
            logger.info("Ajax请求异常,错误内容:" + ex.getMessage());
            // 使用FastJson提供的FastJsonJsonView视图返回，不需要捕获异常
            FastJsonJsonView jsonView = new FastJsonJsonView();
            Map<String, Object> result = new HashMap<>();
            result.put("code", ResponseVO.EXCEPTION);
            result.put("msg", "系统异常，请稍后重试或联系管理员！");
            jsonView.setAttributesMap(result);
            modelAndView.setView(jsonView);
            return modelAndView;
        } else {
            // 如果不是ajax，JSP格式返回
            logger.info("非Ajax请求异常,错误内容:" + ex.getMessage());
            Map<String, Object> result = new HashMap<>();
            result.put("code", ResponseVO.EXCEPTION);
            result.put("msg", "系统异常，请稍后重试或联系管理员！");
            return new ModelAndView("error.jsp", result);
        }
    }
}
