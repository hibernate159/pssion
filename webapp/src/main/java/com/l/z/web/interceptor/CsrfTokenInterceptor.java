package com.l.z.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.l.z.common.annotations.CsrfBindSwitch;
import com.l.z.common.cache.CsrfTokenCache;
import com.l.z.common.utils.ThreadUserTool;

public class CsrfTokenInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CsrfTokenCache csrfTokenCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            CsrfBindSwitch annotation = method.getMethodAnnotation(CsrfBindSwitch.class);
            if (annotation == null || !annotation.open()) {
                return true;
            }
            String token = request.getParameter("_csrf_token");
            boolean check = csrfTokenCache.tokenCheck(ThreadUserTool.getLocalUser().getUserIdStr(), token);
            if (check) {
                return true;
            }
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
