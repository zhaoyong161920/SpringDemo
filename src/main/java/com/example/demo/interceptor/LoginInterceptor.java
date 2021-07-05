package com.example.demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    // 目标方法执行以前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestPath = request.getServletPath();

        if (requestPath.contains(".jsp")){
            log.info("请求拦截，URL为： " + request.getServletPath());
            String newRequestPath = request.getServletPath().replace(".jsp", "");
//            response.sendRedirect(newRequestPath);//request请求参数get和post都带不过去
            request.getRequestDispatcher(newRequestPath).forward(request, response);//参数可以带过去
            return false;
        }

        return true; // false拦截请求不执行，true放行
    }

    // 目标方法执行以后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    // 页面渲染以后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
