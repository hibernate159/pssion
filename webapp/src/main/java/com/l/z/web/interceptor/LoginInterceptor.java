package com.l.z.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.l.z.common.cache.DemoCache;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
        HttpSession session = request.getSession();
        if (session == null) {
            return false;
        }
        // 获得请求路径的uri
        String uri = request.getRequestURI();

        // 进入登录页面，判断session中是否有key，有的话重定向到首页，否则进入登录界面
        if (uri.contains("login")) {
            if (session.getAttribute("user") != null) {
                response.sendRedirect(request.getContextPath());// 默认跟路径为首页
            } else {
                return true;// 继续登陆请求
            }
        }

        // 其他情况判断session中是否有key，有的话继续用户的操作
        if (session.getAttribute("user") != null) {
            // TODO 用户基本内容 --> redis
            
            return true;
        }

        // 最后的情况就是进入登录页面
        response.sendRedirect(request.getContextPath() + "/login.html");
        return false;
    }

}
