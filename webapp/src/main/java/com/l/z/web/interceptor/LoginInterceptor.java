package com.l.z.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.l.z.common.pojo.Demo;
import com.l.z.common.utils.ThreadUserTool;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
        HttpSession session = request.getSession();

        // 获得请求路径的uri
        String uri = request.getRequestURI();
        // 进入登录页面，判断session中是否有key，有的话重定向到首页，否则进入登录界面
        if (uri.contains("show/log")) {
            return true;
        }

        // 其他情况判断session中是否有key，有的话继续用户的操作
        if (session.getAttribute("user") != null) {
            Demo user = (Demo) session.getAttribute("user");
            ThreadUserTool currUser = new ThreadUserTool();
            currUser.setUserIdStr(user.getUname());
            ThreadUserTool.setLocalUser(currUser);
            return true;
        }

        // 最后的情况就是进入登录页面
        response.sendRedirect(request.getContextPath() + "/login.html");
        log.warn("test -log");
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
                    throws Exception {
        ThreadUserTool.removeLocal();
    }
}
