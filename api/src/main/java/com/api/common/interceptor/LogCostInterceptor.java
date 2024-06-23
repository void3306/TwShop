package com.api.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class LogCostInterceptor implements HandlerInterceptor {
    private long start = System.currentTimeMillis();

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        start = System.currentTimeMillis();
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("请求："+httpServletRequest.getRequestURI()+"?"+httpServletRequest.getQueryString()+"，耗时"+(System.currentTimeMillis()-start)+"ms  "+new Date());
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}