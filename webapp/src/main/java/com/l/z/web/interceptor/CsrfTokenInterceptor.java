package com.l.z.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.l.z.common.cache.CsrfTokenCache;
import com.l.z.common.utils.ThreadUserTool;

public class CsrfTokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CsrfTokenCache csrfTokenCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
        // 获得请求路径的uri
        String uri = request.getRequestURI();
        // 进入登录页面，判断session中是否有key，有的话重定向到首页，否则进入登录界面
        if (uri.contains("uploadFile") || uri.contains("show/")) {
            return true;
        }
        String token = request.getParameter("_csrf_token");
        boolean check = csrfTokenCache.tokenCheck(ThreadUserTool.getLocalUser().getUserIdStr(), token);
        if (check) {
            return true;
        }
        response.sendRedirect(request.getContextPath() + "/error.html");
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
                    throws Exception {
        ThreadUserTool.removeLocal();
    }
}
